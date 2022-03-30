package com.ibercode.orders;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.ibercode.orders.model.OrderCreated;
import software.amazon.awssdk.core.SdkSystemSetting;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sfn.SfnClient;
import software.amazon.awssdk.services.sfn.model.StartExecutionRequest;
import software.amazon.awssdk.services.sfn.model.StartExecutionResponse;

import java.util.UUID;

public class Orders implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final Gson GSON = new Gson();
    private final String stateMachineArn = System.getenv("StateMachineArn");

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        OrderCreated order = GSON.fromJson(event.getBody(), OrderCreated.class);
        String orderId = UUID.randomUUID().toString();

        order.setOrderId(orderId);
        order.setOrderStatus("Created");
        order.setPayment("Pending");

        SfnClient sfnClient = SfnClient.builder()
                .region(Region.of(System.getenv(SdkSystemSetting.AWS_REGION.environmentVariable())))
                .build();

        StartExecutionRequest executionRequest = StartExecutionRequest.builder()
                .input(GSON.toJson(order))
                .stateMachineArn(stateMachineArn)
                .name(UUID.randomUUID().toString())
                .build();

        StartExecutionResponse sfnResponse = sfnClient.startExecution(executionRequest);

        sfnResponse.executionArn();

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setBody(orderId);

        return response;
    }
}

package com.example;
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

public class AddAnimal {
    public static void main(String[] args) {
        DynamoDbClient dynamoDb = DynamoDbClient.create();

        Map<String, AttributeValue> item = Map.of(
            "Name", AttributeValue.builder().s("Wolf").build(),
            "Species", AttributeValue.builder().s("Canis lupus").build(),
            "Habitat", AttributeValue.builder().s("Forest").build(),
            "Diet", AttributeValue.builder().s("Carnivore").build(),
            "Sound", AttributeValue.builder().s("Howl").build(),
            "ArtisticRepresentation", AttributeValue.builder().s("🐺").build()
        );

        PutItemRequest request = PutItemRequest.builder()
                .tableName("Animals")
                .item(item)
                .build();

        dynamoDb.putItem(request);

        System.out.println("Animal added to DynamoDB.");
    }
}

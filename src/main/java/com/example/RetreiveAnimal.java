package com.example;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

public class RetreiveAnimal {
    public static void main(String[] args) {
        DynamoDbClient dynamoDb = DynamoDbClient.create();

        ScanRequest scanRequest = ScanRequest.builder()
                .tableName("Animals")
                .build();

        ScanResponse scanResponse = dynamoDb.scan(scanRequest);

        scanResponse.items().forEach(item -> {
            System.out.println("Animal: " + item.get("Name").s());
            System.out.println("Species: " + item.get("Species").s());
            System.out.println("Habitat: " + item.get("Habitat").s());
            System.out.println("Diet: " + item.get("Diet").s());
            System.out.println("Sound: " + item.get("Sound").s());
            System.out.println("Artistic Representation: " + item.get("ArtisticRepresentation").s());
            System.out.println("----------");
        });
    }
}

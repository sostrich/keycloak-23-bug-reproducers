package org.sostrich.keycloak.pocs;

import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.specification.MultiPartSpecification;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class MultipartTests {

    @Test
    void testMultiPart() throws IOException {
        try (var image = Thread.currentThread().getContextClassLoader().getResourceAsStream("random_image.png")) {

            MultiPartSpecification request = new MultiPartSpecBuilder(image)
                    .fileName("random_image.png")
                    .controlName("formFile")
                    .mimeType("image/png")
                    .build();
            var response = given().multiPart(request).body(image).put("http://localhost:8080/realms/master/multipart/multipart").then().extract().response();
            assertThat(response.statusCode(), is(200));
        }
    }

    @Test
    void testNonMultiPart() {
        var response = given().put("http://localhost:8080/realms/master/multipart/non-multipart").then().extract().response();
        assertThat(response.statusCode(), is(200));
    }
}

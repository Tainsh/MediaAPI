package com.kromemedia.mediaapi.controllers;

import com.kromemedia.mediaapi.contollers.MediaAssetController;
import com.kromemedia.mediaapi.dao.MediaAssetRepository;
import com.kromemedia.mediaapi.models.MediaAsset;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest
//@ComponentScan(basePackages = "com.kromemedia.mediaapi")
public class MediaAssetControllerTests {
    @Autowired
    private MediaAssetController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    //@Autowired
    //private MockMvc mockMvc;

   // @Mock
    //private MediaAssetRepository repo;

    @Test
    public void controllerExists() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void createShouldReturnNewAsset() throws Exception {
        MediaAsset testOption = new MediaAsset();
        testOption.setType("video");
        testOption.setSize(256);

        String uri = "http://localhost:" + port + "/mediaAsset";

        MediaAsset result = this.restTemplate.postForObject(uri, testOption, MediaAsset.class);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull();
    }

    @Test
    public void createShouldReturnNewAssetUsingMockMvc() throws Exception {
        MediaAsset testOption = new MediaAsset();
        testOption.setType("video");
        testOption.setSize(256);

        //this.mockMvc.perform(post("/mediaAsset", testOption)).andDo(print());
    }
}

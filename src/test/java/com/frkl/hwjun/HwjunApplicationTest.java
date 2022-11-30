package com.frkl.hwjun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class HwjunApplicationTest extends AbstractTest {
   
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   
   @Test
   public void getPopularityList() throws Exception {
      String uri = "/acc/popularity";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Access[] accesslist = super.mapFromJson(content, Access[].class);
      assertTrue(accesslist.length > 0);
   }
   
   @Test
   public void createAccess() throws Exception {
      String uri = "/adac";
      Access acc = new Access();
      acc.setTimeOfAccess(1669837540);
      acc.setDocumentID("9dbd31fb-3fbc-49dd-9cea-af23dc043c74");
      acc.setUserID("bc045f4d-fafb-40aa-8000-93b65eabd85b");
      String inputJson = super.mapToJson(acc);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Access is created successfully");
   }
}
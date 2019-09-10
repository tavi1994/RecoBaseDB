package com.qa.controllers;
import com.qa.models.Record;
import com.qa.repository.RecordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class RecordsControllerTest {

    @InjectMocks
    private RecordController recordController;

    @Mock
    private RecordRepository repository;
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllRecords(){
        List<Record> recordList = new ArrayList<>();
        Record record = new Record();
        record.setArtist("Bob Marley");
        record.setLabel("IFS330");
        record.setTitle("Exodus");
        record.setYear(1994);
        record.setValue(25);
        recordList.add(record);

        when(repository.findAll()).thenReturn(recordList);
        assertEquals(recordController.listAllRecords().get(0).getArtist(),"Bob Marley");
        //assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/record", List.class)).contains("hello world!");
    }

    @Test
    public void testGetRecordById(){
        List<Record> recordList = new ArrayList<>();
        Record record = new Record();
        record.setArtist("Bob Marley");
        record.setLabel("IFS330");
        record.setTitle("Exodus");
        record.setId(26l);
        record.setYear(1994);
        record.setValue(25);
        recordList.add(record);

        when(repository.findOne(26l)).thenReturn(record);
        assertEquals(recordController.getRecord(26l).getArtist(),"Bob Marley");
    }



}

package com.gen.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.gen.demo.controller.AutoNumberingSequenceController;
import com.gen.demo.domain.AutoNumberingSequence;
import com.gen.demo.service.AutoNumberingSequenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class AutoNumberingSequenceControllerTest {
    @Mock
    private AutoNumberingSequenceService autoNumberingSequenceService;

    @InjectMocks
    private AutoNumberingSequenceController autoNumberingSequenceController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(autoNumberingSequenceController).build();
    }

    @Test
    public void testCreate() throws Exception {
        AutoNumberingSequence sequence = new AutoNumberingSequence();
        sequence.setId(1);

        when(autoNumberingSequenceService.create(any(AutoNumberingSequence.class))).thenReturn(sequence);

        mockMvc.perform(post("/auto-numbering-sequence")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"sequenceNo\":1,\"brandId\":2,\"createdBy\":\"user\",\"createdDate\":\"2024-01-01T00:00:00\"}"))
                .andExpect(status().isOk());

        verify(autoNumberingSequenceService).create(any(AutoNumberingSequence.class));
    }

    @Test
    public void testRead() throws Exception {
        AutoNumberingSequence sequence = new AutoNumberingSequence();
        sequence.setId(1);

        when(autoNumberingSequenceService.read(1)).thenReturn(sequence);

        mockMvc.perform(get("/auto-numbering-sequence/1"))
                .andExpect(status().isOk());

        verify(autoNumberingSequenceService).read(1);
    }

    @Test
    public void testUpdate() throws Exception {
        AutoNumberingSequence sequence = new AutoNumberingSequence();
        sequence.setId(1);

        when(autoNumberingSequenceService.update(eq(1), any(AutoNumberingSequence.class))).thenReturn(sequence);

        mockMvc.perform(put("/auto-numbering-sequence/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"sequenceNo\":2,\"brandId\":2,\"createdBy\":\"user\",\"createdDate\":\"2024-01-01T00:00:00\"}"))
                .andExpect(status().isOk());

        verify(autoNumberingSequenceService).update(eq(1), any(AutoNumberingSequence.class));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/auto-numbering-sequence/1"))
                .andExpect(status().isNoContent());

        verify(autoNumberingSequenceService).delete(1);
    }

    @Test
    public void testPatch() throws Exception {
        AutoNumberingSequence sequence = new AutoNumberingSequence();
        sequence.setId(1);

        when(autoNumberingSequenceService.patch(eq(1), any(AutoNumberingSequence.class))).thenReturn(sequence);

        mockMvc.perform(patch("/auto-numbering-sequence/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"sequenceNo\":3}"))
                .andExpect(status().isOk());

        verify(autoNumberingSequenceService).patch(eq(1), any(AutoNumberingSequence.class));
    }
}


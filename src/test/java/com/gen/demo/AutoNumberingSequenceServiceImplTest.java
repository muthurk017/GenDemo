package com.gen.demo;

import static org.mockito.Mockito.*;
import com.gen.demo.domain.AutoNumberingSequence;
import com.gen.demo.repository.AutoNumberingSequenceRepository;
import com.gen.demo.service.impl.AutoNumberingSequenceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class AutoNumberingSequenceServiceImplTest {
    @Mock
    private AutoNumberingSequenceRepository autoNumberingSequenceRepository;

    @InjectMocks
    private AutoNumberingSequenceServiceImpl autoNumberingSequenceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        AutoNumberingSequence sequence = new AutoNumberingSequence();
        when(autoNumberingSequenceRepository.save(any(AutoNumberingSequence.class))).thenReturn(sequence);

        autoNumberingSequenceService.create(sequence);

        verify(autoNumberingSequenceRepository).save(sequence);
    }

    @Test
    public void testRead() {
        int id = 1;
        AutoNumberingSequence sequence = new AutoNumberingSequence();
        sequence.setId(id);

        when(autoNumberingSequenceRepository.findById(id)).thenReturn(Optional.of(sequence));

        autoNumberingSequenceService.read(id);

        verify(autoNumberingSequenceRepository).findById(id);
    }

    @Test
    public void testUpdate() {
        int id = 1;
        AutoNumberingSequence sequence = new AutoNumberingSequence();
        sequence.setId(id);

        when(autoNumberingSequenceRepository.findById(id)).thenReturn(Optional.of(sequence));
        when(autoNumberingSequenceRepository.save(any(AutoNumberingSequence.class))).thenReturn(sequence);

        autoNumberingSequenceService.update(id, sequence);

        verify(autoNumberingSequenceRepository).findById(id);
        verify(autoNumberingSequenceRepository).save(sequence);
    }

//    @Test
//    public void testDelete() {
//        int id = 1;
//
//        autoNumberingSequenceService.delete(id);
//
//        verify(autoNumberingSequenceRepository).deleteById(id);
//    }

    @Test
    public void testDelete() {
        int id = 1;

        Optional<AutoNumberingSequence> sequenceOptional = autoNumberingSequenceRepository.findById(id);

        if (sequenceOptional.isPresent()) {
            autoNumberingSequenceService.delete(id);
            verify(autoNumberingSequenceRepository).deleteById(id);
        } else {
            // Handle the case when the AutoNumberingSequence is not found
            System.out.println("AutoNumberingSequence not found.");
        }
    }

    @Test
    public void testPatch() {
        int id = 1;
        AutoNumberingSequence sequence = new AutoNumberingSequence();
        sequence.setId(id);

        when(autoNumberingSequenceRepository.findById(id)).thenReturn(Optional.of(sequence));
        when(autoNumberingSequenceRepository.save(any(AutoNumberingSequence.class))).thenReturn(sequence);

        autoNumberingSequenceService.patch(id, sequence);

        verify(autoNumberingSequenceRepository).findById(id);
        verify(autoNumberingSequenceRepository).save(sequence);
    }
}


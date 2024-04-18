package com.gen.demo.service;
import com.gen.demo.domain.AutoNumberingSequence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AutoNumberingSequenceService {
    // Create a new AutoNumberingSequence
    AutoNumberingSequence create(AutoNumberingSequence autoNumberingSequence);

    // Read an AutoNumberingSequence by id
    AutoNumberingSequence read(Integer id);

    // Update an existing AutoNumberingSequence
    AutoNumberingSequence update(Integer id, AutoNumberingSequence autoNumberingSequence);

    // Delete an AutoNumberingSequence by id
    void delete(Integer id);

    // Patch an AutoNumberingSequence by id
    AutoNumberingSequence patch(Integer id, AutoNumberingSequence autoNumberingSequence);
}


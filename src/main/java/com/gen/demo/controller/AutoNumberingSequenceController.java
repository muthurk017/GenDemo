package com.gen.demo.controller;
import com.gen.demo.domain.AutoNumberingSequence;
import com.gen.demo.service.AutoNumberingSequenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/auto-numbering-sequence")
public class AutoNumberingSequenceController {
    private static final Logger logger = LoggerFactory.getLogger(AutoNumberingSequenceController.class);

    @Autowired
    private AutoNumberingSequenceService autoNumberingSequenceService;

    @PostMapping
    public ResponseEntity<AutoNumberingSequence> create(@RequestBody AutoNumberingSequence autoNumberingSequence) {
        logger.info("Creating AutoNumberingSequence");
        AutoNumberingSequence createdSequence = autoNumberingSequenceService.create(autoNumberingSequence);
        logger.info("AutoNumberingSequence created");
        return ResponseEntity.ok(createdSequence);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoNumberingSequence> read(@PathVariable int id) {
        logger.info("Reading AutoNumberingSequence with ID: " + id);
        AutoNumberingSequence sequence = autoNumberingSequenceService.read(id);
        logger.info("AutoNumberingSequence read");
        return ResponseEntity.ok(sequence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoNumberingSequence> update(@PathVariable int id, @RequestBody AutoNumberingSequence autoNumberingSequence) {
        logger.info("Updating AutoNumberingSequence with ID: " + id);
        AutoNumberingSequence updatedSequence = autoNumberingSequenceService.update(id, autoNumberingSequence);
        logger.info("AutoNumberingSequence updated");
        return ResponseEntity.ok(updatedSequence);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        logger.info("Deleting AutoNumberingSequence with ID: " + id);
        autoNumberingSequenceService.delete(id);
        logger.info("AutoNumberingSequence deleted");
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AutoNumberingSequence> patch(@PathVariable int id, @RequestBody AutoNumberingSequence autoNumberingSequence) {
        logger.info("Patching AutoNumberingSequence with ID: " + id);
        AutoNumberingSequence patchedSequence = autoNumberingSequenceService.patch(id, autoNumberingSequence);
        logger.info("AutoNumberingSequence patched");
        return ResponseEntity.ok(patchedSequence);
    }
}


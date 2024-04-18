package com.gen.demo.service.impl;
import com.gen.demo.domain.AutoNumberingSequence;
import com.gen.demo.repository.AutoNumberingSequenceRepository;
import com.gen.demo.service.AutoNumberingSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class AutoNumberingSequenceServiceImpl implements AutoNumberingSequenceService {
    private final AutoNumberingSequenceRepository autoNumberingSequenceRepository;
    private static final Logger logger = LoggerFactory.getLogger(AutoNumberingSequenceServiceImpl.class);

    @Autowired
    public AutoNumberingSequenceServiceImpl(AutoNumberingSequenceRepository autoNumberingSequenceRepository) {
        this.autoNumberingSequenceRepository = autoNumberingSequenceRepository;
    }

    @Override
    public AutoNumberingSequence create(AutoNumberingSequence autoNumberingSequence) {
        logger.info("Creating AutoNumberingSequence...");
        try {
            AutoNumberingSequence createdSequence = autoNumberingSequenceRepository.save(autoNumberingSequence);
            logger.info("AutoNumberingSequence created successfully.");
            return createdSequence;
        } catch (DataAccessException e) {
            logger.error("Error creating AutoNumberingSequence: {}", e.getMessage());
            throw new RuntimeException("Error creating AutoNumberingSequence.", e);
        }
    }

    @Override
    public AutoNumberingSequence read(Integer id) {
        logger.info("Reading AutoNumberingSequence with ID: {}", id);
        try {
            Optional<AutoNumberingSequence> optionalSequence = autoNumberingSequenceRepository.findById(id);
            if (optionalSequence.isPresent()) {
                logger.info("AutoNumberingSequence found.");
                return optionalSequence.get();
            } else {
                logger.warn("AutoNumberingSequence not found.");
                return null;
            }
        } catch (DataAccessException e) {
            logger.error("Error reading AutoNumberingSequence: {}", e.getMessage());
            throw new RuntimeException("Error reading AutoNumberingSequence.", e);
        }
    }

    @Override
    public AutoNumberingSequence update(Integer id, AutoNumberingSequence autoNumberingSequence) {
        logger.info("Updating AutoNumberingSequence with ID: {}", id);
        try {
            Optional<AutoNumberingSequence> optionalSequence = autoNumberingSequenceRepository.findById(id);
            if (optionalSequence.isPresent()) {
                AutoNumberingSequence existingSequence = optionalSequence.get();

                // Update fields of existingSequence
                existingSequence.setSequenceNo(autoNumberingSequence.getSequenceNo());
                existingSequence.setBrandId(autoNumberingSequence.getBrandId());
                existingSequence.setCreatedBy(autoNumberingSequence.getCreatedBy());
                existingSequence.setCreatedDate(autoNumberingSequence.getCreatedDate());
                existingSequence.setUpdatedBy(autoNumberingSequence.getUpdatedBy());
                existingSequence.setUpdatedDate(autoNumberingSequence.getUpdatedDate());

                AutoNumberingSequence updatedSequence = autoNumberingSequenceRepository.save(existingSequence);
                logger.info("AutoNumberingSequence updated successfully.");
                return updatedSequence;
            } else {
                logger.warn("AutoNumberingSequence not found for update.");
                throw new RuntimeException("AutoNumberingSequence not found.");
            }
        } catch (DataAccessException e) {
            logger.error("Error updating AutoNumberingSequence: {}", e.getMessage());
            throw new RuntimeException("Error updating AutoNumberingSequence.", e);
        }
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting AutoNumberingSequence with ID: {}", id);
        try {
            if (autoNumberingSequenceRepository.existsById(id)) {
                autoNumberingSequenceRepository.deleteById(id);
                logger.info("AutoNumberingSequence deleted successfully.");
            } else {
                logger.warn("AutoNumberingSequence not found for deletion.");
                throw new RuntimeException("AutoNumberingSequence not found.");
            }
        } catch (DataAccessException e) {
            logger.error("Error deleting AutoNumberingSequence: {}", e.getMessage());
            throw new RuntimeException("Error deleting AutoNumberingSequence.", e);
        }
    }

    @Override
    public AutoNumberingSequence patch(Integer id, AutoNumberingSequence autoNumberingSequence) {
        logger.info("Patching AutoNumberingSequence with ID: {}", id);
        try {
            Optional<AutoNumberingSequence> optionalSequence = autoNumberingSequenceRepository.findById(id);
            if (optionalSequence.isPresent()) {
                AutoNumberingSequence existingSequence = optionalSequence.get();

                // Apply patch (non-null fields only)
//                if (autoNumberingSequence.getSequenceNo() != null) {
//                    existingSequence.setSequenceNo(autoNumberingSequence.getSequenceNo());
//                }
//                if (autoNumberingSequence.getBrandId() != null) {
//                    existingSequence.setBrandId(autoNumberingSequence.getBrandId());
//                }
                // the above line is generated without considering the int primitive dataType cannot be null
                existingSequence.setSequenceNo(autoNumberingSequence.getSequenceNo());
                existingSequence.setBrandId(autoNumberingSequence.getBrandId());

                if (autoNumberingSequence.getCreatedBy() != null) {
                    existingSequence.setCreatedBy(autoNumberingSequence.getCreatedBy());
                }
                if (autoNumberingSequence.getCreatedDate() != null) {
                    existingSequence.setCreatedDate(autoNumberingSequence.getCreatedDate());
                }
                if (autoNumberingSequence.getUpdatedBy() != null) {
                    existingSequence.setUpdatedBy(autoNumberingSequence.getUpdatedBy());
                }
                if (autoNumberingSequence.getUpdatedDate() != null) {
                    existingSequence.setUpdatedDate(autoNumberingSequence.getUpdatedDate());
                }

                AutoNumberingSequence patchedSequence = autoNumberingSequenceRepository.save(existingSequence);
                logger.info("AutoNumberingSequence patched successfully.");
                return patchedSequence;
            } else {
                logger.warn("AutoNumberingSequence not found for patch.");
                throw new RuntimeException("AutoNumberingSequence not found.");
            }
        } catch (DataAccessException e) {
            logger.error("Error patching AutoNumberingSequence: {}", e.getMessage());
            throw new RuntimeException("Error patching AutoNumberingSequence.", e);
        }
    }
}


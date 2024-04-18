package com.gen.demo.repository;

import com.gen.demo.domain.AutoNumberingSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoNumberingSequenceRepository extends JpaRepository<AutoNumberingSequence, Integer> {
    // Define additional query methods as needed
}


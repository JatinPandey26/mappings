package com.jatinpandey.mappings.Repository;

import com.jatinpandey.mappings.Entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepo extends JpaRepository<Mentor,Long> {
}

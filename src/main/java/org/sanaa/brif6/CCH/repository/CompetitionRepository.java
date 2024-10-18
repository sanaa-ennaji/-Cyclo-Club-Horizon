package org.sanaa.brif6.CCH.repository;

import org.sanaa.brif6.CCH.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository <Competition , Long> {


}

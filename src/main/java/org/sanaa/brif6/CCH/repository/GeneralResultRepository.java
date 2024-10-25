package org.sanaa.brif6.CCH.repository;

import org.sanaa.brif6.CCH.entity.GeneralResult;
import org.sanaa.brif6.CCH.entity.embedded.EmbeddedGeneralResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralResultRepository extends JpaRepository<GeneralResult, EmbeddedGeneralResult> {
}

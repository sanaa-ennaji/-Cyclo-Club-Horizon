package org.sanaa.brif6.CCH.repository;

import org.sanaa.brif6.CCH.entity.EmbeddedGeneralRId;
import org.sanaa.brif6.CCH.entity.GenarlResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenaralResultRepository  extends JpaRepository <GenarlResult, EmbeddedGeneralRId>{
}

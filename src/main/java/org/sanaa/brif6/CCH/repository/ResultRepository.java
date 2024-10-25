package org.sanaa.brif6.CCH.repository;

import org.sanaa.brif6.CCH.entity.Result;
import org.sanaa.brif6.CCH.entity.embedded.EmbeddedResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, EmbeddedResult> {
}

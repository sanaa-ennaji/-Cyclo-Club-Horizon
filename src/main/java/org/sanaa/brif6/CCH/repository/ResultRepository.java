package org.sanaa.brif6.CCH.repository;

import org.sanaa.brif6.CCH.entity.EmbeddedresultId;
import org.sanaa.brif6.CCH.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository <Result, EmbeddedresultId> {


}

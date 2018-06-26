package com.zup.poi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zup.poi.models.Poi;

public interface PoiRepository extends JpaRepository<Poi, String>{

	@Query(value = "SELECT "
	  + " p.name "
	  + "FROM "
	  + "  poi p"
	  + " WHERE "
	  +	" "
	  +	" ("
	  +	"	SQRT( "
	  +	"		power( p.coordinatex - :coordinatex, 2 )+ power( p.coordinatey - :coordinatey, 2 )"
	  +	" ) "
	  +	" 	) <= :distance", nativeQuery = true)
	public List<String> findAllByCoordinate(@Param("coordinatex") long coordinatex, @Param("coordinatey") long coordinatey, @Param("distance") long distance);
}

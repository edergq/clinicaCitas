package org.joedayz.acweb.dao;

import java.util.List;


import org.joedayz.acweb.domain.Rol;;

public interface RolDAO {
	public List<Rol> getRol() throws Exception;
	public int registrarRolUser(Long co_role)throws Exception;
	
	
}

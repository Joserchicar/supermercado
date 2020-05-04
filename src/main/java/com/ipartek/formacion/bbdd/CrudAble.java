package com.ipartek.formacion.bbdd;

import java.util.ArrayList;

public interface CrudAble<P> {

	ArrayList<P>getAll() throws Exception;
	P getById(int id) throws Exception;
	P delete(int id) throws Exception;
	P insert(P p) throws Exception;
	P update(P p) throws Exception;
	
}

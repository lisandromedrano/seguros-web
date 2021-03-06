/*
 * Created on 13 jul 2014 ( Time 20:15:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.lix.domain.master.productores.dto;

import java.io.Serializable;

import com.lix.domain.master.productores.dto.*;
import com.lix.dto.PaginationParams;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import java.util.List;

import javax.persistence.*;



/**
 * Dto for "Productores"
 *
 * @author Telosys Tools Generator
 *
 */
public class ProductoresDto extends PaginationParams
{
    


		    private Integer id          ;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
			    private String nombre;

			    private String apellido;

			    private String dni;

			    private String matricula;

    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
	    public void setId( Integer id )
    {
        this.id = id ;
    }
    public Integer getId()
    {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : NOMBRE ( VARCHAR ) 
    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return this.nombre;
    }

    //--- DATABASE MAPPING : APELLIDO ( VARCHAR ) 
    public void setApellido( String apellido )
    {
        this.apellido = apellido;
    }
    public String getApellido()
    {
        return this.apellido;
    }

    //--- DATABASE MAPPING : DNI ( VARCHAR ) 
    public void setDni( String dni )
    {
        this.dni = dni;
    }
    public String getDni()
    {
        return this.dni;
    }

    //--- DATABASE MAPPING : MATRICULA ( VARCHAR ) 
    public void setMatricula( String matricula )
    {
        this.matricula = matricula;
    }
    public String getMatricula()
    {
        return this.matricula;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------




    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString()
    {
		return "";
		//return ReflectionToStringBuilder.toString(this);
    }

}

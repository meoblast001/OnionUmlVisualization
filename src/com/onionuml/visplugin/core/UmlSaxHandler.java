package com.onionuml.visplugin.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.onionuml.visplugin.core.UmlRelationshipElement.Multiplicity;

/**
 * Handles SAX2 events for reading a UML class model from a ClassML
 * XML document.
 */
public class UmlSaxHandler extends DefaultHandler {
	
	// PRIVATE MEMBER VARIABLES --------------------------------
	
	private String mTitle;
	private Map<String,UmlNodeElement> mNodes = new HashMap<String,UmlNodeElement>();
	private Map<String,UmlRelationshipElement> mRelationships =
			new HashMap<String,UmlRelationshipElement>();
	
	private Stack<String> mElementNames = new Stack<String>();
	private Stack<Object> mObjects  = new Stack<Object>();
	
	
	// OVERRIDE METHODS -----------------------------------
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		mElementNames.push(qName);
		
		if(qName.equals("classml")){
			mTitle = attributes.getValue("title");
		}
		else if(qName.equals("class")){
			String id = attributes.getValue("id");
			String label = attributes.getValue("label");
			String stereotype = attributes.getValue("stereotype");
			String isAbstract = attributes.getValue("isAbstract");
			UmlNodeElement node = new UmlNodeElement((label.length() > 0 ? label : "     "),
					(stereotype != null) ? stereotype : "");
			node.setIsAbstract(isAbstract != null && (isAbstract.equals("true") || isAbstract.equals("1")));
			mObjects.push(node);
			mNodes.put(id, node);
		}
		else if(qName.equals("attribute")){
			Visibility vis = Visibility.parseVisibility(attributes.getValue("visibility"));
			String label = attributes.getValue("label");
			String dataType = attributes.getValue("dataType");
			UmlNodeAttribute a = new UmlNodeAttribute(vis, label, dataType);
			UmlNodeElement node = (UmlNodeElement)mObjects.peek();
			node.addAttribute(a);
		}
		else if(qName.equals("operation")){
			Visibility vis = Visibility.parseVisibility(attributes.getValue("visibility"));
			String label = attributes.getValue("label");
			String returnType = attributes.getValue("returnType");
			String isStatic = attributes.getValue("isStatic");
			String isAbstract = attributes.getValue("isAbstract");
			UmlNodeOperation o = new UmlNodeOperation(vis, label, returnType,
					isStatic != null && (isStatic.equals("true") || isStatic.equals("1")),
					isAbstract !=  null && (isAbstract.equals("true") || isAbstract.equals("1")));
			UmlNodeElement node = (UmlNodeElement)mObjects.peek();
			node.addOperation(o);
			mObjects.push(o);
		}
		else if(qName.equals("parameter")){
			String label = attributes.getValue("label");
			String dataType = attributes.getValue("dataType");
			UmlNodeOperationParameter op = new UmlNodeOperationParameter(label, dataType);
			UmlNodeOperation o = (UmlNodeOperation)mObjects.peek();
			o.parameters.add(op);
		}
		else if(qName.equals("relationship")){
			String id = attributes.getValue("id");
			String label = attributes.getValue("label");
			RelationshipType type = RelationshipType
					.parseRelationshipType(attributes.getValue("type"));
			String headId = attributes.getValue("head");
			String tailId = attributes.getValue("tail");
			Multiplicity headMultMin = Multiplicity
					.parseMultiplicity(attributes.getValue("headMultiplicityMin"));
			Multiplicity headMultMax = Multiplicity
					.parseMultiplicity(attributes.getValue("headMultiplicityMax"));
			Multiplicity tailMultMin = Multiplicity
					.parseMultiplicity(attributes.getValue("tailMultiplicityMin"));
			Multiplicity tailMultMax = Multiplicity
					.parseMultiplicity(attributes.getValue("tailMultiplicityMax"));
			
			// disable invalid multiplicity configurations
			if((headMultMin == Multiplicity.ZERO && headMultMax == Multiplicity.ZERO)
					|| (headMultMin == Multiplicity.ONE && headMultMax == Multiplicity.ZERO)
					|| (headMultMin == Multiplicity.MANY && headMultMax == Multiplicity.ZERO)
					|| (headMultMin == Multiplicity.MANY && headMultMax == Multiplicity.ONE)){
				headMultMin = Multiplicity.NONE;
				headMultMax = Multiplicity.NONE;
			}
			if((tailMultMin == Multiplicity.ZERO && tailMultMax == Multiplicity.ZERO)
					|| (tailMultMin == Multiplicity.ONE && tailMultMax == Multiplicity.ZERO)
					|| (tailMultMin == Multiplicity.MANY && tailMultMax == Multiplicity.ZERO)
					|| (tailMultMin == Multiplicity.MANY && tailMultMax == Multiplicity.ONE)){
				tailMultMin = Multiplicity.NONE;
				tailMultMax = Multiplicity.NONE;
			}
			
			UmlRelationshipElement r = new UmlRelationshipElement(label, headId, tailId, type,
					headMultMin, headMultMax, tailMultMin, tailMultMax);
			mRelationships.put(id, r);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		mElementNames.pop();

		if(qName.equals("class") || qName.equals("operation")){
			mObjects.pop();
		}
	}
	
	
	
	// PUBLIC METHODS -------------------------------------
	
	/**
	 * Returns the title of the UML class model.
	 */
	public String getTitle(){
		return mTitle;
	}
	
	/**
	 * Gets a map of each model node id string to its corresponding node.
	 */
	public Map<String,UmlNodeElement> getNodes(){
		return mNodes;
	}
	
	/**
	 * Gets a map of each model relationship id string to its corresponding relationship.
	 */
	public Map<String,UmlRelationshipElement> getRelationships(){
		return mRelationships;
	}
}

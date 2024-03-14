package fr.axl.axl.repositories;

import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "recipe-instruction")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecipeInstructionDO {

    private String text;
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    
}

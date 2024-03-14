package fr.axl.axl.repositories;

import java.net.URI;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "recipe")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecipeDO {

    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    private Long rating;
    public Long getRating() { return rating; }
    public void setRating(Long rating) { this.rating = rating; }
    
    private boolean bookmarked;
    public boolean getBookmarked() { return bookmarked; }
    public void setBookmarked(boolean bookmarked) { this.bookmarked = bookmarked; }

    @XmlElement(name = "image-url")
    private URI imageUrl;
    public URI getImageUrl() { return imageUrl; }
    public void setImageUrl(URI imageUrl) { this.imageUrl = imageUrl; }

    @XmlElementWrapper(name = "instructions")
    @XmlElement(name = "instruction")
    private List<RecipeInstructionDO> instruction;
    public List<RecipeInstructionDO> getInstructions() { return instruction; }
    public void setInstructions(List<RecipeInstructionDO> instruction) { this.instruction = instruction; }
    
    
}

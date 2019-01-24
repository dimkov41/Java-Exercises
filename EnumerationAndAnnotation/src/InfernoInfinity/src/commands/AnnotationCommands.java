package commands;

import annotations.Weapon;

public class AnnotationCommands {
    private final Class clazz = models.Weapon.class;
    private final Weapon weapon = (Weapon) clazz.getAnnotation(Weapon.class);

    public String getAuthorName(){
        return String.format("Author: %s",weapon.author());
    }

    public String getRevision(){
        return String.format("Revision: %d",weapon.revision());
    }

    public String getDescription(){
        return String.format("Class description: %s",weapon.description());
    }

    public String getReviewers(){
        return "Reviewers: " + String.join(", ",weapon.reviewers());
    }
}

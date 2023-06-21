package Encapsulation.Exercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy")||bakingTechnique.equals("Chewy")||bakingTechnique.equals("Homemade")){
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
       if (weight>=1 && weight<=200) {
           this.weight = weight;
       }else {
           throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
       }
    }
    public double calculateCalories() {
        double flourModifier;
        double techniqueModifier;
        if (this.flourType.equals("White")) {
            flourModifier = 1.5;
        } else {
            flourModifier = 1.0;
        }
        if (this.bakingTechnique.equals("Crispy")) {
            techniqueModifier = 0.9;
        } else if (this.bakingTechnique.equals("Chewy")) {
            techniqueModifier = 1.1;
        } else {
            techniqueModifier = 1.0;
        }
        return (this.weight*2)*techniqueModifier*flourModifier;
    }
}

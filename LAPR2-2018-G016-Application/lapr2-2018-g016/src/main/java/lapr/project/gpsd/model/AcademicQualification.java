/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author momog
 */
public class AcademicQualification {

    String designation;
    String degree;
    double classification;

    public AcademicQualification(String designation, String degree, double classification) {
        if (designation == null || designation.isEmpty() || degree == null || degree.isEmpty()) {
            throw new NullPointerException();
        }
        if (classification < 0 || classification > 20) {
            throw new IllegalArgumentException();
        }
        this.designation = designation;
        this.degree = degree;
        this.classification = classification;

    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Double getClassification() {
        return classification;
    }

    public void setClassification(double classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Academic Qualification:\n" + "designation=" + designation + ", degree=" + degree + ", classification=" + classification;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.designation);
        hash = 79 * hash + Objects.hashCode(this.degree);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.classification) ^ (Double.doubleToLongBits(this.classification) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        AcademicQualification obj = (AcademicQualification) o;
        return (Objects.equals(designation, obj.designation)
                && Objects.equals(degree, obj.degree)
                && Objects.equals(classification, obj.classification));
    }
}

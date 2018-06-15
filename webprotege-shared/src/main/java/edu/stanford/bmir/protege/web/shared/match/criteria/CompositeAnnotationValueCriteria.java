package edu.stanford.bmir.protege.web.shared.match.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 14 Jun 2018
 */
@AutoValue
@GwtCompatible(serializable = true)
@JsonTypeName("CompositeAnnotation")
public abstract class CompositeAnnotationValueCriteria implements AnnotationValueCriteria {

    private static final String ANNOTATION_VALUES = "annotationValues";

    @Nonnull
    @JsonProperty(ANNOTATION_VALUES)
    public abstract ImmutableList<? extends AnnotationValueCriteria> getAnnotationValueCriteria();


    @JsonCreator
    @Nonnull
    public static CompositeAnnotationValueCriteria get(@Nonnull @JsonProperty(ANNOTATION_VALUES) ImmutableList<? extends AnnotationValueCriteria> annotationValueCriteria) {
        return new AutoValue_CompositeAnnotationValueCriteria(annotationValueCriteria);
    }

    @Override
    public <R> R accept(@Nonnull AnnotationValueCriteriaVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
package fi.vm.yti.codelist.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@Entity
@JsonFilter("externalReference")
@Table(name = "externalreference")
@XmlRootElement
@XmlType(propOrder = {"uri", "titles", "descriptions"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({"id"})
@ApiModel(value = "ExternalReference", description = "ExternalReference model that represents data for either CodeScheme or Code related external link.")
public class ExternalReference implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String uri;
    private Map<String, String> titles;
    private Map<String, String> descriptions;
    private Set<CodeScheme> codeSchemes;
    private Set<Code> codes;
    private PropertyType propertyType;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Column(name = "uri")
    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "externalreference_title", joinColumns = @JoinColumn(name = "externalreference_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "title")
    @OrderColumn
    public Map<String, String> getTitles() {
        if (titles == null) {
            titles = new HashMap<>();
        }
        return titles;
    }

    public void setTitles(final Map<String, String> titles) {
        this.titles = titles;
    }

    public String getTitle(final String language) {
        String title = titles.get(language);
        if (title == null) {
            title = titles.get(LANGUAGE_CODE_EN);
        }
        return title;
    }

    public void setTitle(final String language, final String name) {
        if (titles == null) {
            titles = new HashMap<>();
        }
        if (language != null && name != null && !name.isEmpty()) {
            titles.put(language, name);
        } else if (language != null && name == null) {
            titles.remove(language);
        }
        setTitles(titles);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "externalreference_description", joinColumns = @JoinColumn(name = "externalreference_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "description")
    @OrderColumn
    public Map<String, String> getDescriptions() {
        if (descriptions == null) {
            descriptions = new HashMap<>();
        }
        return descriptions;
    }

    public void setDescriptions(final Map<String, String> descriptions) {
        this.descriptions = descriptions;
    }

    public String getDescription(final String language) {
        String description = descriptions.get(language);
        if (description == null) {
            description = descriptions.get(LANGUAGE_CODE_EN);
        }
        return description;
    }

    public void setDescription(final String language, final String name) {
        if (descriptions == null) {
            descriptions = new HashMap<>();
        }
        if (language != null && name != null && !name.isEmpty()) {
            descriptions.put(language, name);
        } else if (language != null && name == null) {
            descriptions.remove(language);
        }
        setDescriptions(descriptions);
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "externalReferences")
    public Set<CodeScheme> getCodeSchemes() {
        return this.codeSchemes;
    }

    public void setCodeSchemes(final Set<CodeScheme> codeSchemes) {
        this.codeSchemes = codeSchemes;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "externalReferences")
    public Set<Code> getCodes() {
        return this.codes;
    }

    public void setCodes(final Set<Code> codes) {
        this.codes = codes;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "propertytype_id", nullable = false, insertable = true, updatable = true)
    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(final PropertyType propertyType) {
        this.propertyType = propertyType;
    }
}

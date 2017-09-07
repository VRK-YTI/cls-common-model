package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Object model that represents a street address entity.
 */
@Entity
@JsonFilter("streetAddress")
@Table(name = "streetaddress")
@NamedEntityGraph(name = "streetAddressListing",
        attributeNodes = {
            @NamedAttributeNode(value = "uri"),
            @NamedAttributeNode(value = "municipality", subgraph = "municipality"),
            @NamedAttributeNode(value = "streetNumbers", subgraph = "streetNumbers")
        },
        subgraphs = {
            @NamedSubgraph(name = "streetNumbers",
                    type = StreetNumber.class,
                    attributeNodes = {
                            @NamedAttributeNode("uri"),
                            @NamedAttributeNode(value = "postalCode", subgraph = "postalCode"),
                            @NamedAttributeNode(value = "streetAddress", subgraph = "streetAddress")
                    }
            ),
            @NamedSubgraph(name = "municipality",
                    type = Municipality.class,
                    attributeNodes = {
                            @NamedAttributeNode("uri")
                    }
            )
        },
        subclassSubgraphs = {
                @NamedSubgraph(name = "postalCode",
                        type = PostalCode.class,
                        attributeNodes = {
                                @NamedAttributeNode("uri")
                        }
                ),
                @NamedSubgraph(name = "streetAddress",
                        type = StreetAddress.class,
                        attributeNodes = {
                                @NamedAttributeNode("uri")
                        }
                )
        }
)
@XmlType(propOrder = { "uri", "id", "source", "status", "created", "modified", "prefLabels", "municipality", "streetNumbers" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(value = { "code" })
@ApiModel(value = "StreetAddress", description = "StreetAddress model that represents data for one single streetaddress.")
public class StreetAddress extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Municipality municipality;
    private List<StreetNumber> streetNumbers;

    public StreetAddress() {}

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "municipality_id")
    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(final Municipality municipality) {
        this.municipality = municipality;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "streetAddress")
    public List<StreetNumber> getStreetNumbers() {
        return streetNumbers;
    }

    public void setStreetNumbers(final List<StreetNumber> streetNumbers) {
        this.streetNumbers = streetNumbers;
    }

    public String toString() {
        return "(" +
                "uri: " + getUri() + ", " +
                "source: " + getSource() + ", " +
                "status: " + getStatus() + ", " +
                "created: " + getCreated() + ", " +
                "modified: " + getModified() + ", " +
                "prefLabels: " + getPrefLabels() + ")";
    }

}

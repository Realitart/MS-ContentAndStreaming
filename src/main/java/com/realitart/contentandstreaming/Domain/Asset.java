package com.realitart.contentandstreaming.Domain;

import com.realitart.contentandstreaming.share.models.AuditModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Assets")
public class Asset extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long artworkId;
    private String url;
    private Double positionX;
    private Double positionY;
    private Double positionZ;
    private Double scaleX;
    private Double scaleY;
    private Double scaleZ;
    private Double rotationX;
    private Double rotationY;
    private Double rotationZ;
}

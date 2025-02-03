package com.example.products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "productos")  // Asegurar que coincida con la BD
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @NotNull(message = "El nombre del producto es obligatorio")
    @Size(min = 1, message = "El nombre del producto no puede estar vacío")
    @Column(name = "nombreProducto", nullable = false, length = 255, unique = true)
    private String nombreProducto;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @NotNull(message = "La marca es obligatoria")
    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    @Column(name = "codigoFabricante", length = 100)
    private String codigoFabricante;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    @Column(name = "precio", nullable = false)
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "ubicacion_almacen", length = 100)
    private String ubicacionAlmacen;

    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;
}

# andreas-lab2
Raytracer

# Raytracer i Java

Programmet använder en stationär kamera och skickar strålar genom varje pixel i bilden. Rays testas mot alla objekt i scenen och den närmaste träffen avgör pixelns färg.

## Projektets innehåll

`Vector3D` för vektorberäkningar  
`Ray` för strålar från kameran  
`Shape` som gemensamt interface för former  
`Sphere/Triangle` som konkreta former  
`Scene` som lagrar alla former  
`Renderer` som renderar scenen  
`Color` för RGB-färger

*Resultatet sparas som `render.png` i projektets rootmapp.*

---

## Lägga till en ny Shape

För att lägga till en ny form i raytracern skapar man en ny klass som implementerar `Shape`-interfacet.

Exempel, ej implementerat i koden just nu:

```java

public class Plane implements Shape {

    private final Color color;

    public Plane(Color color) {
        this.color = color;
    }

    @Override
    public HitResult hit(Ray ray) {
        // Beräkna om rayen träffar formen.
        // Returnera HitResult med om det är en träff samt avstånd.
        return new HitResult(false, 0);
    }

    @Override
    public Color getColor() {
        return color;
    }
}
```

När `Plane` har implementerats kan den läggas till i scenen, exempelvis i `Main`:
        

Plane plane = new Plane(new Color(255, 255, 0));
scene.addShape(plane);


`Scene` och `Renderer` behöver inte ändras när en ny form läggs till, eftersom de arbetar med `Shape`interfacet istället för specifika former som `Sphere` och `Triangle`.

Det gör att programmet kan byggas på enligt `Open/Closed Principle`: nya former kan läggas till utan att den befintliga renderingslogiken behöver ändras.
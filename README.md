### Escuela Colombiana de Ingeniería

### Ciclo de Vida de Desarrollo de Software

### Desarrollo Dirigido por Pruebas + DIP + DI

Para este taller se va a trabajar sobre el juego del ahorcado.

El sistema actual de puntuación del juego comienza en 100 puntos y va
descontando 10 puntos cada vez que se propone una letra incorrecta.

Algunos usuarios han propuesto diferentes esquemas para realizar la
puntuación, los cuales se describen a continuación:

* OriginalScore:
    * Es el esquema actual, se inicia con 100 puntos.
    * No se bonifican las letras correctas.
    * Se penaliza con 10 puntos con cada letra incorrecta.
    * El puntaje minimo es 0.

* BonusScore:
    * El juego inicia en 0 puntos.
    * Se bonifica con 10 puntos cada letra correcta.
    * Se penaliza con 5 puntos cada letra incorrecta.
    * El puntaje mínimo es 0

* PowerBonusScore:
    * El juego inicia en 0 puntos.
    * La $i-ésima$ letra correcta se bonifica con $5^i$.
    * Se penaliza con 8 puntos cada letra incorrecta.
    * El puntaje mínimo es 0
    * Si con las reglas anteriores sobrepasa 500 puntos, el puntaje es
        500.

Lo anterior, se traduce en el siguiente modelo, donde se aplica el
principio de inversión de dependencias:

![imagen](img/model.png)

### Parte I

1. Haga un fork del proyecto (no lo descargue directamente!).

![image](https://github.com/koket987/LAB03-CVDS/assets/97971883/42bd3eba-eb71-4cf8-8e15-4f5ee920ef78)

![image](https://github.com/koket987/DependencyInjectionHangman/assets/97971883/bd6426d7-5492-442f-8441-ecfaca6b617a)

2. A partir del código existente, implemente sólo los cascarones del
   modelo antes indicado.

3. Haga la especificación de los métodos calculateScore (de las tres
   variantes de GameScore), a partir de las especificaciones
   generales dadas anteriormente. Recuerde tener en cuenta: @pre,
   @pos, @param, @throws.


   Original Score

   ![MicrosoftTeams-image (20)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/5c56afe9-adf1-4078-bf43-ce5410d4144b)

   Bonus Score

   ![MicrosoftTeams-image (21)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/629ba7ac-114a-4473-a4bc-8fe95083067f)

   Power Score

   ![MicrosoftTeams-image (22)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/a059eb8b-c624-4eb6-bca4-e56e1ab58a61)


5. Haga commit de lo realizado hasta ahora. Desde la terminal:

    ```sh		
    git add .			
    git commit -m "especificación métodos"
    ```

6. Actualice el archivo `pom.xml` e incluya las dependencias para la ultima versión de JUnit.

7. Teniendo en cuenta dichas especificaciones, en la clase donde se
   implementarán las pruebas (GameScoreTest), en los
   comentarios iniciales, especifique las clases de equivalencia para
   las tres variantes de GameScore, e identifique
   condiciones de frontera.

![MicrosoftTeams-image (24)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/9673f1a8-c6ac-47cf-800f-72b4f5bbf839)

![MicrosoftTeams-image (25)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/56e87bc6-6821-4e6c-bca4-ab0d3ee647a7)

![MicrosoftTeams-image (26)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/0dc8420b-fd08-44f1-a73d-062b7e8c56d7)

![MicrosoftTeams-image (27)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/f2991fb9-baf6-465e-83fe-3280d1ee43ff)

![MicrosoftTeams-image (28)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/4e041599-8e88-46d6-9bec-8737251e17b8)

![MicrosoftTeams-image (29)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/d41b723a-eb53-489c-9219-c0ff1084a966)

8. Para cada clase de equivalencia y condición de frontera, implemente
   una prueba utilizando JUnit.

9. Haga commit de lo realizado hasta ahora. Desde la terminal:

    ```sh		
    git add .			
    git commit -m "implementación pruebas"
    ```
![MicrosoftTeams-image (23)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/7c724aa4-2c89-480a-a48c-a47cb58635e9)

10. Realice la implementación de los 'cascarones' realizados anteriormente.
   Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores
   se ejecutan satisfactoriamente.


   ![image](https://github.com/koket987/LAB03-CVDS/assets/97971883/6fae5b40-5895-44ad-a397-cb69b9495cb9)
   

11. Al finalizar haga un nuevo commit:

    ```sh		
    git add .			
    git commit -m "implementación del modelo"
    ```

12. Para sincronizar el avance en el respositorio y NO PERDER el trabajo, use
    el comando de GIT para enviar los cambios:

    ```sh
    git push origin main
    ```
![MicrosoftTeams-image (30)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/3dfe94f7-166e-4015-8942-9f07bc5f2830)

### Parte II

Actualmente se utiliza el patrón FactoryMethod
que desacopla la creación de los objetos para diseñar un juego
de ahorcado (revisar setup.factoryMethod, el
constructor de la clase GUI y HangmanFactoryMethod).

1. Utilizando el HangmanFactoryMethod (MétodoFabrica) incluya el
   OriginalScore a la configuración.

* Mediante la configuración de la Inyección de
  Dependencias se pueda cambiar el comportamiento del mismo, por
  ejemplo:
    * Utilizar el esquema OriginalScore.
    * Utilizar el esquema BonusScore.
    * Utilizar el idioma francés.
    * Utilizar el diccionario francés.
    * etc...

![MicrosoftTeams-image (31)](https://github.com/PDSW-ECI/DependencyInjectionHangman/assets/97971883/c334d611-31b9-43e6-a458-90fb01b0929b)


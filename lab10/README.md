# Programação  Orientada por Objetos 2024/2025

## Ficha de Laboratório #10

## Objetivos

> - Introdução ao JavaFX

## Programa

O objetivo deste laboratório é a criação de um projeto JavaFX (ver [JavaFX Community Site](https://openjfx.io/)), em BlueJ, com o intuito de consolidar conhecimentos e praticar a matéria dada em aula.

Neste laboratório será desenvolvida uma aplicação de raiz que utilize o JavaFX composta por vários componentes (`Shape`). Esses componentes terão de ser manipulados através da alterações das suas propriedades cor e tamanho, bem como com aplicação de transformações de rotação e translação.

## Ferramentas

- BlueJ
- JavaFX

## Regras de Implementação

- Aceitar o assignment do GitHub Classroom
- Clonar o repositório gerado pelo GitHub Classroom
- Utilizar o IDE BlueJ.
- Implementar o código necessário e testar no fim de cada nível.
- Use as convenções de codificação adotadas para a linguagem Java (ver **Notas**).

## Implementação

### Nivel 1

Numa primeira fase pretende-se a criação de uma aplicação que crie uma imagem que representa um ovo num prato:

![Ovo no Prato](images/egg-dish.png)  
Figura - 1

Esta imagem é criada através de várias `Shape` sobrepostas num painel `StackPane`.

Vamos começar por dar um valor para a altura e largura da janela. Crie as constantes `WINDOW_WIDTH` e `WINDOW_HEIGHT` com os respetivos valores de `700.0` e `500.0`.

Crie o painel (`StackPane`): para ser genérico utilize uma variável da classe base dos paineis [Pane](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/layout/Pane.html).

Defina a cor de fundo do painel como sendo `blue` através do uso de [setStyle](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setStyle(java.lang.String)) e recorrendo ao uso da propriedade CSS `"-fx-background-color"` ([JavaFX CSS Reference Guide](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/doc-files/cssref.html)).

Defina a [Scene](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Scene.html) com o painel e com as dimensões anteriormente criadas.

Acrescente a cena à janela principal [Stage](https://openjfx.io/javadoc/24/javafx.graphics/javafx/stage/Stage.html) e defina o seu título conforme a imagem.

Apresente a janela principal obtendo uma janela com o seguinte aspeto:

![Nível 1](images/level1.png)  
Figura - 2

### Nível 2

Agora iremos acrescentar os vários elementos (*Gema*, *Clara* e *Prato*) ao painel. As características de cada `Shape` são:

|     Elemento     |  Shape  | Radius (X/Y) |  Fill  |     Stroke    | Transformação   |
|------------------|---------|--------------|--------|---------------|-----------------|
| Prato (plate)    | Circle  | 200.0        | RED    | 20.0, DARKRED | -               |
| Clara (eggWhite) | Ellipse | 120.0, 80.0  | WHITE  | -             | Rotate, 45.0    |
| Gema  (eggYolk)  | Circle  | 50.0         | YELLOW | -             | -               |

A documentação sobre as várias `Shape` pode ser obtida em [Shape Package](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/shape/package-summary.html).

Escolha o construtor que melhor se adapta para criar a `Shape` com as características pretendidas e posteriormente utilize *`setters`* para acertar as restantes características (ex. para rodar a *Clara* deve usar [setRotate](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setRotate(double))).

Adicione as `Shape`, pela ordem correta, ao painel antes da apresentação da janela principal.

Deverá obter uma imagem idêntica à Figura - 1.

### Nível 3

Vamos alterar a aplicação para criarmos novos elementos gráficos que possam ser posicionado nos paneis e movimentados.

Pretende-se criar uma imagem com o seguinte aspeto:

![Foguetão no Planeta](images/rocket-planet.png)  
Figura - 3

Comece por alterar o conteúdo do método `start`: sugere-se que mantenham as linhas que criam e manipulam o painel, a cena e a janela. Alterando-se apenas a criação do painel para um objeto da classe `Pane` e alterando o título da janela para o indicado na Figura - 3. As restantes linhas podem ser eliminadas (ou comentadas).

Seguidamente deverá ser criada a representação do planeta (`planet`) através da criação de um `Circle` com as seguintes características:

| centerX | centerY | radius |    fill    |
|---------|---------|--------|------------|
| 350.0   | 1000.0  | 700.0  | DARK BROWN |

Uma vez que não existe na classe `Color` um valor enumerado que represente a cor [DARK BROWN](https://convertingcolors.com/rgb-color-101_67_33.html) ou [DARK BROWN](https://rgb.to/rgb/101,67,33) será necessário recorrer a sua definição através dos respetivos valores RGB (101, 67, 33) e com o método estático [Color.rgb](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/paint/Color.html#rgb(int,int,int)).

Adicionando o `planet` ao painel, obtem-se o seguinte aspeto:

![Céu e Planeta](images/sky-planet.png)  
Figura - 4

De seguida deverão ser adicionadas as nuvens:

![Nuvem](images/cloud.png)  
Figura - 5

As nuvens vão ser criadas através de 5 elipses:

![Elipses das Nuvens](images/cloud-ellipses.png)  
Figura - 6

Como serão necessárias várias nuvens deverá ser criada uma classe `Cloud` que permitirá ter a representação de uma nuvem, sendo depois instanciados vários elementos dessa classe com coordenadas diferentes.

A classe `Cloud` deverá ser subclasse de `Pane` pois será um painel com as 5 elipses. O seu construtor deve receber as coordenadas (`x` e `y`) e posicionar-se através dos método [setLayoutX](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setLayoutX(double)) e [setLayoutY](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setLayoutY(double)). As 5 elipses deverão ser criadas através de um método privado (`createEllipse`), e acrescentadas ao painel.

O método `createEllipse` deverá criar elipse com raios X/Y respetivamente 35.0/15.0 (sugere-se a criação de constantes `RADIUS_X` e `RADIUS_Y`). A sua cor será a `LIGHTGRAY` (também se deve criar uma constante para a cor a fim de tornar o código mais genérico).

Os centros de cada elipse podem ser determinados através de múltiplos dos respetivos raios:

| Ordem    | dx  | dy  |
|----------|-----|-----|
| Elipse 1 | 1.5 | 1.0 |
| Elipse 2 | 3.0 | 1.0 |
| Elipse 3 | 1.0 | 2.0 |
| Elipse 4 | 2.5 | 2.0 |
| Elipse 5 | 3.5 | 2.0 |

A título de exemplo a primeira elipse (`1`) será criada através de `new Ellipse(RADIUS_X * dx, RADIUS_Y * dy, RADIUS_X, RADIUS_Y);`, com `RADIUS_X` a valer `35.0`, `RADIUS_Y` a valer `15.0`, `dx` a valer `1.5` e `dy` a valer `1.0`, respetivamente.

As 3 nuvens serão criadas nas posições [`150.0`,`100.0`], [`500.0`,`150.0`] e [`60.0`,`200.0`], respetivamente:

![Céu, Planeta e Nuvens](images/sky-planet-clouds.png)  
Figura - 7

## Nivel 4

De seguida pretende-se criar o foguetão seguindo uma estratégia semelhante à das nuvens: criar uma classe, que herda de `Pane`, esta classe colocará no painel os elementos constitutivos do foguetão e será posicionado movendo-se as coordenadas do painel (`setLayoutX` e `setLayoutY`):

![Foguetão](images/rocket.png)  
Figura - 8

O foguetão é constituído por 1 retângulo e 3 triângulos:

![Estrutura do Foguetão](images/rocket-structure.png)  
Figura - 9

Assim, à semelhança da estratégia utilizada nas nuvens, sugere-se a criação dois métodos privados, um para criar o retângulo (`createRectangle`) e outro para os triângulos (`createTriangle`). Deverão ser criadas constantes para guardar as dimensões e cores envolvidas na criação dos elementos do foguetão:

![Dimensões do Foguetão](images/rocket-dimensions.png)  
Figura - 10

|   Constante  |   Valor  |
|--------------|----------|
| BODY_WIDTH   | 80.0     |
| BODY_HEIGHT  | 150.0    |
| TIP_HEIGHT   | 50.0     |
| FOOT_HEIGHT  | 50.0     |
| FOOT_WIDTH   | 50.0     |
| FOOT_DX      | 15.0     |
| FOOT_DY      | 20.0     |
| STROKE_WIDTH | 2.0      |
| BODY_COLOR   | GREY     |
| OTHER_COLOR  | BURGUNDY |
| STROKE_COLOR | BLACK    |

Uma vez mais, a cor `BURGUNDY` (Borgonha - [BURGUNDY](https://convertingcolors.com/rgb-color-128_0_32.html) ou [BURGUNDY](https://rgb.to/rgb/128,0,32)) não existe pré-definida, como um enumerado, na classe `Color`, sendo necessário recorrer a sua definição através dos respetivos valores RGB (128, 0, 32) e com o método estático [Color.rgb](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/paint/Color.html#rgb(int,int,int)).

Com base nas constante definidas anteriormente é possível criar os elementos constitutivos do foguetão (usando os métodos `createRectangle` e `createTriangle`). Convém relembrar que os triângulos são criado como polígonos, através da indicação dos 3 pontos vértices:

|   Elemento  |   Shape   |                 x                 |                 y                |     width    |     height    |
|-------------|-----------|-----------------------------------|----------------------------------|--------------|---------------|
| Topo        | Polygon   | `FOOT_DX`                         | `0.0`                            | `BODY_WIDTH` | `TIP_HEIGHT`  |
| Pé Esquerdo | Polygon   | `0.0`                             | `TIP_HEIGHT+BODY_HEIGHT-FOOT_DY` | `FOOT_WIDTH` | `FOOT_HEIGHT` |
| Pé Direito  | Polygon   | `FOOT_DX*2+BODY_WIDTH-FOOT_WIDTH` | `TIP_HEIGHT+BODY_HEIGHT-FOOT_DY` | `FOOT_WIDTH` | `FOOT_HEIGHT` |
| Corpo       | Rectangle | `FOOT_DX`                         | `TIP_HEIGHT`                     | `BODY_WIDTH` | `BODY_HEIGHT` |

A criação dos triângulos através dos polígonos é feita indicando os 3 pontos: [`x`,`y+height`], [`x+width/2.0`,`y`] e [`x+width`,`y+height`].

Com o foguetão criado e depois de adicionado ao painel principal deve-se obter uma imagem idêntica à Figura - 3:

![Foguetão no Planeta](images/rocket-planet.png)

## Nível 5

Finalmente, com toda a cena desenvolvida, vamos alterar o código de forma a que seja possível mover o foguetão na vertical (como se fosse descolar).

A movimentação do foguetão é baseado nos 3 `event handler` associados ao rato:

- [setOnMousePressed](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setOnMousePressed(javafx.event.EventHandler))
- [setOnMouseDragged](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setOnMouseDragged(javafx.event.EventHandler))
- [setOnMouseReleased](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setOnMouseReleased(javafx.event.EventHandler))

O foguetão (painel `Pane`) será movimentado através do método [setTranslateY](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setTranslateY(double)).

Deve ser adicionado um novo atributo de instância (`initialY`) que guardará, no início ([setOnMousePressed](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setOnMousePressed(javafx.event.EventHandler))) a coordenada em `Y` (obtida através de [getSceneY](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/input/MouseEvent.html#getSceneY())).

Quando se move o rato, com o botão premido ([setOnMouseDragged](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setOnMouseDragged(javafx.event.EventHandler))), o painel deverá sofrer uma translação vertical de `setTranslateY(Math.min(0.0, -(this.initialY - e.getSceneY())))`.

Quando se libertar o rato ([setOnMouseReleased](https://openjfx.io/javadoc/24/javafx.graphics/javafx/scene/Node.html#setOnMouseReleased(javafx.event.EventHandler))) o valor da translação vertical deve ser reposto a zero: `setTranslateY(0)`.

Defina os  `event handler` no `Pane` e teste a aplicação, tentando "agarrar" e "mover" o foguetão.

**Notas**:

Para os identificadores siga as convenções adotadas normalmente, em particular:

1. A notação **camelCase** para o nome das variáveis locais e identificadores de atributos e métodos.
2. A notação **PascalCase** para os nomes das classes.
3. A notação **SCREAMING_SNAKE_CASE** para as constantes e os valores de enum
4. Não utilize o símbolo ‘_’, nem abreviaturas nos identificadores.

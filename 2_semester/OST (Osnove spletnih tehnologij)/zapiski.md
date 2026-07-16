# OST - Osnove spletnih tehnologij
### Podrobni zapiski za izpit

---

## KAZALO
1. [HTML](#1-html)
2. [CSS](#2-css)
3. [Responsive Web Design](#3-responsive-web-design)
4. [XML / XHTML](#4-xml--xhtml)
5. [JavaScript](#5-javascript)
6. [Ajax](#6-ajax)
7. [HTTP](#7-http)
8. [Seje (Sessions)](#8-seje-sessions)
9. [Strežniška stran](#9-strežniška-stran)
10. [REST](#10-rest)
11. [Razno (MVC, React, SEO, varnost)](#11-razno-mvc-react-seo-varnost)
12. [Banka izpitnih vprašanj z odgovori](#12-banka-izpitnih-vprašanj-z-odgovori)

---

## 1. HTML

### Zakaj sploh HTML? (osnovni problem)
Osnovni problem spleta: kako pripraviti en računalnik, da drugemu prikaže vsebino, čeprav so strojno/programsko popolnoma različni? Rešitev potrebuje **tri stvari**:
1. **dokumentni format**, ki ga razumejo tako naprave kot ljudje → **HTML**
2. **program**, ki zna te dokumente prikazati na čim več platformah → **brskalnik**
3. **način izmenjave** dokumentov med računalniki → **HTTP**

### Odjemalec/strežnik arhitektura
- **Strežnik** = ima vsebino in jo (po)streže.
- **Odjemalec/klient** = tisti, ki dostopa do vsebine (npr. brskalnik).
- Klient pošlje **zahtevo (request)**, strežnik vrne **odgovor (response)**.

### Zgodovina (na kratko)
1971 SGML → 1990 HTML → 1990–2000 HTML 2/3.2/4.0, XHTML 1.0 → 2014 HTML5.

**Pomembno:** HTML **ni programski jezik**, ampak **označevalni (markup) jezik** - označuje pomen besedila, ne ukazuje procesorju. Znotraj HTML lahko sicer vključimo programski jezik (JavaScript).

### Osnovni pojmi
- **Označba (tag):** `<ime_značke>...</ime_značke>`
- **Tipi elementov:**
  - **prazni (void)** - nimajo vsebine niti zaključne značke: `<link>`, `<input>`, `<img>`
  - **čisto tekstovni** - vsebina se ne interpretira: `<plaintext>`
  - **normalni** - imajo odprto in zaključno značko: `<p>...</p>`
- **Atributi:** `<značka atribut="vrednost">` (v HTML5 tudi brez narekovajev za enostavne vrednosti)

### Minimalna vs. polna HTML5 stran
```html
<!doctype html>
<html lang="sl">
  <head>
     <meta charset="utf-8">
     <title>Naslov</title>
     <link rel="stylesheet" href="style.css">
     <script src="script.js"></script>
  </head>
  <body>
     Prikazana vsebina
  </body>
</html>
```
Minimalna (HTML5 dopušča izpust `<head>`/`<body>` oznak, brskalnik jih doda sam):
```html
<!doctype html>
<html lang=sl>
  <title>Naslov</title>
  <body>Prikazana vsebina</body>
</html>
```

### Unicode / UTF-8
Slovenske črke (č, š, ž) niso v ASCII, so pa v Unicode tabeli. Zato vedno uporabimo `<meta charset="UTF-8">`. Znake lahko zapišemo tudi kot entitete: `&#268;` (decimalno), `&#x10C;` (hex) ali `&Ccaron;` (imenska entiteta) - vse pomeni **Č**.

### Najpomembnejše značke (s pomenom)
| Značka | Kaj dela |
|---|---|
| `<h1>`–`<h6>` | Naslovi poglavij, od najpomembnejšega (`h1`) do najmanj pomembnega (`h6`) |
| `<p>` | Odstavek besedila |
| `<a>` | Povezava (anchor) na drug dokument ali del dokumenta |
| `<img>` | Vstavi sliko (prazen element, ima `src` in `alt`) |
| `<ol>` | Oštevilčen seznam (ordered list) |
| `<ul>` | Neoštevilčen seznam (unordered list, z alinejami) |
| `<li>` | Element seznama (list item) - znotraj `<ol>`/`<ul>` |
| `<dl>` | Seznam definicij (description list) |
| `<dt>` / `<dd>` | Izraz (term) / opis (description) znotraj `<dl>` |
| `<div>` | Splošni (block) vsebnik brez lastnega pomena - za skupinjenje/CSS/JS |
| `<span>` | Splošni (inline) vsebnik brez lastnega pomena - za del besedila |
| `<table>` | Tabela (samo za tabelarične podatke!) |
| `<tr>` / `<td>` / `<th>` | Vrstica tabele / celica / glava stolpca |
| `<form>` | Vnosni obrazec za pošiljanje podatkov strežniku |
| `<input>` | Vnosno polje (prazen element; tip določa `type`) |
| `<select>` / `<option>` | Spustni seznam / posamezna izbira v njem |
| `<label>` | Opis/napis za vnosni element (poveže se z `for="id"`) |
| `<link>` | Poveže zunanji vir (npr. CSS datoteko) v `<head>` (prazen element) |
| `<meta>` | Metapodatki o dokumentu (npr. znakovni nabor, opis) - prazen element |
| `<title>` | Naslov strani (prikazan v zavihku brskalnika) |
| `<script>` | Vključi ali vsebuje JavaScript kodo |
| `<style>` | Vsebuje CSS pravila znotraj HTML datoteke |
| `<head>` | Glava dokumenta - metapodatki, naslov, povezave na CSS/JS (ni vidna vsebina) |
| `<body>` | Telo dokumenta - vsa vidna vsebina strani |
| `<html>` | Korenski element celotnega HTML dokumenta |

HTML5 ima skupaj ~110 značk - zgornje so tiste, ki se najpogosteje pojavljajo na izpitu.

### Logične vs. izrecne oznake
- **Logične** (priporočeno): `<em>`, `<strong>`, `<blockquote>`, `<code>`, `<cite>`... - povedo *pomen*, brskalnik sam izbere najprimernejši prikaz.
- **Izrecne** (zastarelo/deprecated): `<b>`, `<i>`, `<u>`, `<strike>` - vsiljujejo *videz*.
- **Zakaj je to pomembno?** Če rečeš `<em>`, brskalnik lahko to prikaže poševno, na zaslonu za slepe pa lahko to prebere z drugim glasom. Če vsiljuješ `<i>`, take fleksibilnosti ni.
- Tabelo `<table>` uporabljamo **samo** za tabelarične podatke, nikoli za postavitev/layout strani (stara slaba praksa).

### Povezave (linki)
1. Na drug dokument: `<a href="URL">...</a>`
2. Znotraj istega dokumenta: `<a href="#oznaka">...</a>` + `<a name="oznaka">` (ali `id="oznaka"`)
3. Na določeno točko v drugem dokumentu: `<a href="URL#oznaka">...</a>`

### Vnosni obrazci (forms)
```html
<form method="get" action="kocke.html">
    <label for="M">model kocke:</label>
    <select id="M" name="model">
        <option>igralna</option>
        <option>granitna</option>
    </select><br>
    <input type="checkbox" id="D" name="darilo" value="da">
    <label for="D">darilno pakiranje</label><br>
    Način plačila:
    <input type="radio" id="P" name="placilo" value="povzetje">
    <label for="P">po povzetju</label>
    <input type="radio" id="CC" name="placilo" value="kartica">
    <label for="CC">kreditna kartica</label><br>
    <input type="submit" value="Pošlji"> <input type="reset" value="Brisi">
</form>
```
Ključni atributi `<form>`: `method` (GET ali POST), `action` (kam se pošlje). Znotraj forme: `<input>`, `<select>`, `<textarea>` z atributi `type`, `name`, `value`, `size`.

### Novi semantični elementi (HTML5)
`<article>`, `<aside>`, `<details>`, `<figure>`/`<figcaption>`, `<footer>`, `<header>`, `<main>`, `<mark>`, `<nav>`, `<section>`, `<summary>`, `<time>` - namesto generičnih `<div>`-ov povedo **pomen** dela strani (npr. `<nav>` = navigacija). To pomaga tudi SEO in dostopnosti (accessibility).

### Media elementi
`<audio>`, `<video>`, `<embed>`, `<source>`, `<track>` - vsi za multimedijsko vsebino brez potrebe po vtičnikih (plugins) kot je bil nekoč Flash.

### Standardni (globalni) atributi
Delujejo na **vseh** elementih:
- `class` - element je član skupine (za CSS/JS)
- `id` - unikatni identifikator elementa
- `style` - eksplicitno stiliziranje (raje uporabi .css!)
- `lang` - jezik vsebine
- `title` - dodaten opis (tooltip)

**💡 Past na izpitu:** Beseda, ki je lahko hkrati ime elementa IN ime atributa: **`style`** (`<style>` element in `style=""` atribut). To je vprašanje #6 v banki vprašanj.

### HTML vs. HTML5 - razlike ⭐
| | HTML (4.01 in prej) | HTML5 (2014) |
|---|---|---|
| Doctype | dolg, zapleten (`<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" ...>`) | preprost: `<!doctype html>` |
| Semantični elementi | ni jih - vse je `<div>`/`<span>` s class/id | ima `<header>`, `<nav>`, `<article>`, `<section>`, `<aside>`, `<footer>`, `<main>` |
| Multimedija | potrebni vtičniki (Flash, plugins) za video/avdio | vgrajena `<video>`, `<audio>` brez vtičnikov |
| Grafika | ni vgrajenih orodij | `<canvas>` (2D risanje), podpora za SVG |
| Obrazci (forms) | osnovni `<input>` tipi (text, checkbox...) | novi tipi: `email`, `date`, `number`, `range`, `color` + validacija (`required`, `pattern`) |
| API-ji | brez vgrajenih Web API-jev | Geolocation API, Web Storage (localStorage/sessionStorage), Drag & Drop, Offline (Service Worker) |
| Zapiranje elementov | strožje (bližje XML, sploh v XHTML) | bolj tolerantno - `<br>` je lahko brez `/` |
| Atributi brez narekovajev | ne (razen v HTML, XHTML zahteva narekovaje) | dovoljeno za enostavne vrednosti: `<html lang=sl>` |
| Cilj zasnove | prikaz dokumentov | polnopravne spletne aplikacije (SPA, offline, multimedija...) |

**Bistvo:** HTML5 ni "nova različica istega" po majhnih popravkih - prinese **pomen** (semantiko), **multimedijo** in **API-je** za grajenje aplikacij, ne le dokumentov.

---

## 2. CSS

### Zakaj CSS?
CSS = **Cascading Style Sheets** - pravila, kako naj se HTML element prikaže na eni ali več straneh.

**Prednosti:**
- Prihranek pri delu - spremeniš EN dokument, spremeni se izgled cele strani (ali več strani)
- HTML koda je čistejša (brez oznak za izrecno oblikovanje)
- Lažje vzdrževanje
- Več oblikovnih možnosti kot čisti HTML

### Sintaksa
```
Selektor { Atribut : VrednostAtributa; … }
```
Primer:
```css
form {
   display: block;
   margin-top: 1mm;
}
```
- **Selektor** = formula, ki opiše katere elemente ciljamo (`h1`, `p`, `div ul.sredina`, `#vsebina:hover`)
- **Lastnost (property)** = ime atributa (`color`, `font-size`, `text-transform`)
- **Vrednost** = dejanska nastavitev (`yellow`, `12px`, `uppercase`)

### Trije načini vključitve CSS v HTML (klasično izpitno vprašanje #11!)
1. **Zunanja datoteka** - velja za vse HTML strani, ki jo naložijo:
   ```html
   <link rel="stylesheet" href="css-file">
   ```
2. **Znotraj `<head>`** z `<style>` - velja samo za to HTML datoteko, prekrije prejšnja pravila:
   ```html
   <style type="text/css">
      h1 {color : blue ;}
   </style>
   ```
3. **Neposredno v znački** (inline) - dokončno oblikovanje enega elementa:
   ```html
   <p style="color: red;">Odstavek v rdeči barvi</p>
   ```

### Postavitev elementov - block vs. inline
- **block** (nivojski blok) - privzeto se zložijo eden pod drugega (kot odstavki). Univerzalni block element: `<div>`.
- **inline** - postavijo se eden poleg drugega (kot črke v besedi). Univerzalni inline element: `<span>`.
- Temeljni tekstovni blok: `<p>`.

### CSS Box Model
Vsak blok je "škatla", sestavljena (od zunaj navznoter) iz:
```
Margin → Border → Padding → Content
```
- **margin** = razmik zunaj roba (do sosednjih elementov)
- **border** = rob škatle
- **padding** = notranji razmik (med robom in vsebino)
- **content** = dejanska vsebina

### Identifikacija elementov: id vs. class
| | `id` | `class` |
|---|---|---|
| Koliko elementov ima lahko isto ime | samo 1 na strani | poljubno mnogo |
| Selektor v CSS | `#ime` (lojtra) | `.ime` (pika) |
| En element več imen? | ne (1 id) | da (`class="a b c"`) |

```html
<style>
    #msg { color: red; }
    .msg { color: green; }
    p { color: blue; }
</style>
...
<p id="msg" class="msg">Sporočilo uporabniku</p>   <!-- rdeč, ker id zmaga -->
<p class="msg">Zdravo!</p>                          <!-- zelen -->
<p>Navaden odstavek...</p>                          <!-- moder -->
```

### Specifičnost / prekrivanje selektorjev (pomembno za izpit!)
Če se več pravil ujema z istim elementom, zmaga **najbolj specifično** pravilo, po vrstnem redu pomembnosti (od najmočnejšega):
1. **inline style** (`<h1 style="color:blue">`)
2. **id** (`#menu`)
3. **class, psevdo-razred, atribut** (`.alfa`, `:hover`, `[href]`)
4. **element, psevdo-element** (`h1`, `:before`)

Če je specifičnost enaka, zmaga **zadnje** definirano pravilo. Pravila v isti datoteki > pravila v zunanji datoteki (pri enaki specifičnosti).

---

## 3. Responsive Web Design

### Problem
Naprave se med sabo zelo razlikujejo po velikosti/resoluciji zaslona. Strategije:
- **Fixed** - nespremenljiva velikost
- **Fluid** - prilagajanje glede na širino (%)
- **Adaptive** - različne postavitve za različne naprave (ločeni "profili")
- **Elastic** - fixed + fluid na osnovi velikosti fonta (em)
- **Responsive** - **isti design** se fluidno prilagaja mediju ⭐ (to je cilj)

### 3 pristopi za mobilno
1. **Native mobile app** - največ interaktivnosti/prestiža, ampak drago
2. **Dedicated mobile site** - ločena mobilna stran, hiter a začasen ukrep
3. **Responsive site** - ena koda, en vmesnik, ki se prilagaja - najbolj vzdržljivo

### Bootstrap (2011)
Prosto ogrodje (framework) za responsive strani. Prednosti: preprost (HTML+CSS), responsive, mobile-first, kompatibilen z brskalniki.

**Grid sistem:** kontejner → vrstice (`.row`) → celice (`.col`), ki lahko zasedejo do 12 logičnih stolpcev vrstice.
```html
<div class="container-fluid text-center">
  <div class="row">
      <div class="col-sm-8">col-sm-8</div>
      <div class="col-sm-4">col-sm-4</div>
  </div>
  <div class="row">
      <div class="col-md">col-md</div>
      <div class="col-md">col-md</div>
  </div>
</div>
```

### W3CSS grid sistem
Predefinirane velikosti: **small** (`s`, <601px), **medium** (`m`, <992px), **large** (`l`, ≥992px). Vrstica = `.w3-row`, celica z 1 stolpcem = `.w3-col`, širina po velikosti zaslona: `.l1`-`.l12`, `.m1`-`.m12`, `.s1`-`.s12`. Če vrstica preseže 12 stolpcev, se prelomi.

### Plusi/minusi CSS ogrodij (Bootstrap/W3CSS)
| ✅ Plusi | ❌ Minusi |
|---|---|
| Enostavna uporaba (HTML+CSS) | Razredi vplivajo na VSE HTML elemente |
| Responsive lastnosti | Preveč razredov → nepregleden, nesemantičen HTML |
| Kompatibilnost z brskalniki | Konflikt z obstoječo kodo |
| Hiter rezultat | Vse strani izgledajo podobno |
| | Ogrodje postane pomembnejše od vsebine |

---

## 4. XML / XHTML

### XML - Extensible Markup Language (razširljiv označevalni jezik)
- Namenjen **prenosu in hranjenju** podatkov (ne prikazu!)
- Nima predefiniranih elementov (sam si jih izmisliš)
- XML **ni namenjen, da bi "naredil" karkoli** - samo opisuje strukturo podatkov

### Dodatno o XML (po w3schools.com/xml) - čemu služi v praksi
- **XML loči podatke od predstavitve (prikaza).** XML ne nosi nobene informacije o tem, kako naj bo nekaj prikazano - ista XML vsebina se lahko prikaže na povsem različne načine (spletna stran, mobilna aplikacija, izpis...).
- **XML je pogosto dopolnilo HTML-ju**, ne njegova zamenjava: XML hrani/prenaša podatke, HTML pa jih oblikuje in prikaže uporabniku.
- **XML loči podatke od same HTML datoteke** - če se podatki spremenijo, ti ni treba urejati HTML datoteke; z malo JavaScript kode lahko prebereš XML datoteko in samodejno posodobiš vsebino katerekoli HTML strani.
- Na tisoče XML formatov obstaja za različne panoge (borzni podatki, finančne transakcije, medicinski podatki, znanstvene meritve, vremenske službe, novičarski servisi ...) - XML je pravzaprav univerzalni "kontejner" za strukturirane podatke, ne glede na področje.

Primer preprostega XML dokumenta za shranjevanje podatkov o knjigi (podobno kot bi shranili v bazo):
```xml
<?xml version="1.0" encoding="UTF-8"?>
<knjiznica>
   <knjiga zvrst="kuharska">
      <naslov jezik="sl">Vsakdanja italijanska kuhinja</naslov>
      <avtor>Giada De Laurentiis</avtor>
      <leto>2005</leto>
      <cena>30.00</cena>
   </knjiga>
   <knjiga zvrst="otroška">
      <naslov jezik="sl">Harry Potter</naslov>
      <avtor>J. K. Rowling</avtor>
      <leto>2005</leto>
      <cena>29.99</cena>
   </knjiga>
</knjiznica>
```
Tak dokument bi lahko brala tako spletna stran (prikaže seznam knjig) kot mobilna aplikacija ali drug program - brez spreminjanja podatkov samih.

### 5 pravil "dobro oblikovanega" (well-formed) XML dokumenta ⭐ (izpitno vprašanje #26/29)
1. Vsi elementi morajo biti **zaključeni**
2. XML **loči velike/male črke** (case sensitive)
3. Elementi morajo biti **pravilno gnezdeni**
4. Dokument mora imeti **natančno en korenski element**
5. Atributi morajo biti v **dvojnih narekovajih**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<samo_en_dokumentni_element>
   <podElement>
      <pravilno_gnezdenje_1>
          <pravilno_gnezdenje_2></pravilno_gnezdenje_2>
      </pravilno_gnezdenje_1>
   </podElement>
   <vsakElementJeZakljucen />
   <VelikeMaleCrkeSoPomembne atribut="v narekovajih" />
</samo_en_dokumentni_element>
```

**Dobro oblikovan (well-formed)** = samo pravilna sintaksa.
**Veljaven (valid)** = dobro oblikovan **in** ustreza priloženi shemi (DTD/XML Schema).

### XHTML = "HTML pisan kot XML"
Nastal je, ker so bile HTML strani pogosto pisane površno (brskalniki so tolerantni na napake), pojavile pa so se nove naprave (TV, telefoni), ki potrebujejo strožji format.

Za združljivost nazaj z XML pravili:
```
<a HREF=mojurl></a>   →   <a href="mojurl"></a>
<br>                  →   <br /> ali <br></br>
<td nowrap>           →   <td nowrap="nowrap">
```

### XML vs. XHTML - razlike ⭐
| | XML | XHTML |
|---|---|---|
| Namen | prenos/hranjenje **podatkov** (splošen jezik) | **prikaz** vsebine (podmnožica HTML) |
| Predefinirani elementi | **nima jih** - sam si izmisliš imena (`<knjiga>`, `<cena>`...) | ima jih - enaka nabor kot HTML (`<p>`, `<div>`, `<a>`...) |
| Skladnost | mora biti dobro oblikovan (5 pravil) | HTML zapisan **kot** dobro oblikovan XML (strožja sintaksa) |
| Brskalnik ga razume? | ne prikaže se neposredno (potrebuje XSLT/CSS za prikaz) | da, deluje kot HTML |
| Primer razlike | `<Cena>10</Cena>` in `<cena>10</cena>` sta RAZLIČNA elementa (case sensitive) | isto pravilo case sensitivity velja tudi tu, ker XHTML sledi XML pravilom |
| Odnos med njima | XHTML je **pisan po XML pravilih**, torej je XHTML tehnično podmnožica/aplikacija XML-a, uporabljena za isti namen kot HTML | "XHTML je HTML pisan kot XML" |

**Kratek povzetek za izpit:** XML = splošen jezik za **podatke** (brez vnaprej določenih značk); XHTML = **HTML**, ki **striktno upošteva XML sintaktična pravila** (zaključene značke, male črke, narekovaji, gnezdenje, en koren).

**XHTML5** = HTML5 zapisan v XML-skladni obliki. Strežnik ga mora dostaviti kot `application/xhtml+xml` MIME tip, da brskalnik vklopi XML parser. Potreben je XML imenski prostor:
```xml
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
   <head><meta charset="utf-8" /><title>...</title></head>
   <body>...</body>
</html>
```

### XML procesiranje: DOM vs. SAX
**DOM** = Document Object Model (objektni model dokumenta) - **SAX** = Simple API for XML (preprost API za XML)

| | DOM | SAX |
|---|---|---|
| Tip | drevesni (tree-based) | dogodkovni (event-based) |
| Kako deluje | prebere **cel** dokument v pomnilnik kot drevo | sproža dogodke med branjem, brez branja v celoti |
| Prednost | omogoča vse manipulacije (branje, urejanje, dodajanje) | idealen za **velike** dokumente, ko ne rabiš vsega naenkrat |
| Slabost | lahko zelo potraten pri velikih dokumentih | že obdelanih vozlišč ne moreš ponovno obdelati |

### XML sheme - 5 področij uporabe
1. **Validacija** - najpogostejša uporaba, preveri strukturo in vsebino
2. **Dokumentiranje** - strojno berljiv opis XML besednjaka
3. **Poizvedbe** - poznavanje strukture pospeši iskanje/sortiranje (XPath, XSLT, XQuery)
4. **Povezovanje podatkov** - avtomatska preslikava XML → podatkovna struktura v aplikaciji
5. **Urejanje** - urejevalniki lahko pomagajo (npr. "ali lahko sem vstavim ta element?")

### XSL / XSLT / XPath / XQuery
- **XSLT** - jezik za **transformacijo** XML dokumentov v drugo obliko (npr. XML → HTML), deluje nad drevesom vozlišč
- **XPath** - sintaksa za naslavljanje/izbor delov XML dokumenta (podobno CSS selektorjem, a splošnejše)
- **XQuery** - povpraševalni (query) jezik za XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match="/"> ... </xsl:template>
 <xsl:template match="ime-elementa"> ... </xsl:template>
</xsl:stylesheet>
```

---

## 5. JavaScript

### Kaj sploh je JS?
Interpretiran (ne prevajan!) jezik, ki ga v okviru HTML izvaja **brskalnik**. Standard na klientu (>97 % strani ga uporablja), na strežniku manj razširjen.

**Interpretiran** pomeni: interpreter kodo **hkrati bere in izvaja** (v nasprotju s prevajanjem v strojno kodo vnaprej).

### Namen in omejitve
Znotraj HTML JS omogoča **popoln nadzor nad HTML dokumentom**, NE pa nad računalnikom (sicer bi zlonamerni programerji lahko upravljali z našim računalnikom!). Ker je interpretiran, ni namenjen dolgi/kompleksni kodi - napake pridejo na dan šele med izvajanjem.

### Zgodovina
Nastal v Netscape projektu. Preimenovanja: Mocha → LiveScript → **JavaScript**. Od 1996 standardiziran pri **ECMA** (European Computer Manufacturers Association - Evropsko združenje proizvajalcev računalnikov) kot **ECMAScript (ES)** - JS je implementacija tega standarda.

### JS vs. Java - ključne razlike ⭐
- Spremenljivk **ni treba najavljati**, samo uporabiš
- **Weakly-typed** - tip se prilagodi vsebini
- **Dvigovanje (hoisting)** spremenljivk in funkcij
- **First-class funkcije** - funkcija je vrednost
- **Prototipno programiranje** - brez pravih razredov

### Glavni podatkovni tipi
```js
x = 42;                 // Number
x = 123456789012345678901234n;  // BigInt
x = true;                // Boolean
x = 'ponedeljek';        // String
x = {ime:'Miki miška', letnik:1928};   // Object
x = [10, 20, 50];        // Array (podtip Objecta!)
```

### Rahlo tipiziran jezik + vsiljevanje tipov (type coercion)
```js
alfa = "nekaj"; alfa = 123;   // ista spremenljivka, drug tip - OK!
cena = 12.75; cena = cena + "€";  // "12.75€"

1 + null == 1
"1" - 1 == 0
"1" + 1 == "11"
"beseda" * 1 == NaN
null == undefined    // true (ohlapna primerjava)
null !== undefined   // true (stroga - različen tip)
```
**💡 Za izpit:** `==` primerja vrednost s pretvorbo tipov, `===`/`!==` primerja tudi tip.

### var / let / const ⭐ (zelo pogosto izpitno vprašanje)
| | `var` | `let` | `const` |
|---|---|---|---|
| Doseg | globalni/funkcijski | blokovni | blokovni |
| Ponovna deklaracija | dovoljena | prepovedana | prepovedana |
| Sprememba vrednosti | da | da | **ne** |
| Postane lastnost `window` | da | ne | ne |

```js
var i = 5;
for (var i=0; i<7; i++) { }   // i == window.i == 7 (ista spremenljivka)

let i = 5;
for (let i=0; i<7; i++) { }   // zunanji i == 5 (nova, blokovna)
```

### Dvigovanje (Hoisting)
```js
alfa = stevilo;   // undefined (var je dvignjen, vrednost pa ne)
var stevilo;

beta = gama;      // ReferenceError! let/const se ne dvigneta enako
let gama;

naredi();  // 42 - definirana funkcija je dvignjena v celoti
function naredi() { return 42; }

naredi();  // Error - dvigne se le spremenljivka, ne vsebina (expression)
naredi = function () { return 13; }
```

### Funkcije - 3 načini definicije
```js
function alfa() {...}              // definicija (dvigljiva)
alfa = function() {...};           // izraz (expression)
alfa = (param1, param2) => {...};  // arrow funkcija (brez svojega this!)
```

### Funkcija kot first-class citizen
```js
function vrni10() { return 3+7; }
y = vrni10();       // klic → 10
f = vrni10;         // referenca na funkcijo, BREZ klica
logiraj(vrni10);    // funkcija kot parameter
```

### Lastnosti objektov
```js
mm = {ime:'Miki', priimek:'Miška'};
console.log(mm.ime);        // pika
console.log(mm['ime']);     // oglati oklepaji - univerzalno
mm['partner'] = 'Mini';     // doda
delete mm.letnik;           // briše
```

### Metode + `this`
```js
function aloalo() { console.log('It is I, ' + this.ime); }
let obj = {ime:"Leclerc", aloalo};
obj.aloalo();          // this = obj
aloalo.call(obj);      // isti učinek - prvi parameter call() postane this
```
Arrow funkcije **nimajo** svojega `this`.

### Razredi vs. prototipi vs. konstruktorske funkcije
JS prvotno ni imel razredov - samo prototipe. `class` je "sladkor" nad prototipnim sistemom.
```js
class Problem {
   constructor(year) { this.year = year; }
   odgovor() { return 42; }
   get leto() { return "Piše se leto " + this.year; }
   set leto(value) { this.year = value; }
}
let korona = new Problem(2019);
console.log(korona.leto);   // "Piše se leto 2019"
```

### Posebnosti - past za izpit ⭐
```js
4 == 4      // true
4 == '4'    // true (coercion)
4 !== '4'   // true
NaN != NaN  // true! (NaN ni enak niti sam sebi)
Object.is(NaN, NaN)  // true

for (let elt of "abc") {}  // a, b, c  (VREDNOSTI)
for (let elt in "abc") {}  // 0, 1, 2  (INDEKSI/lastnosti)
```

### OOP koncepti v JS
**Enkapsulacija** - `let` closure ali `#` notacija. **Dedovanje** - `extends`/`super`. **Polimorfizem** - objekti "dedujejo" metode prototipov, jezik vedno kliče "pravo" metodo.

### Nalaganje skripte - vrstni red je pomemben! ⭐
Brskalnik: 1) pridobi HTML → 2) začne parse → 3) na `<script src="...">` **ustavi** parse, počaka, izvede JS → 4) nadaljuje.
```html
<script src="demo_async.js" defer></script>
```
- **async** - izvede takoj po prejemu, vrstni red več skript ni zagotovljen
- **defer** - izvede v pravem vrstnem redu, na koncu dokumenta

### Dogodkovno voden jezik (Event-driven)
```js
let elt = document.getElementById("message");
elt.addEventListener("mouseover", function(){ goodbye('OST') });
```

### DOM
HTML je predstavljen kot **drevesna struktura** objektnih vozlišč:
```js
elt = document.getElementById("prvi");
elt.classList.add("aktiven");
```

### Omejitve JavaScripta v brskalniku ⭐
1. Ne more pisati na strežniške datoteke
2. Nima dostopa do podatkovne baze na strežniku
3. Ne more brati/pisati datotek na klientu
4. Ne more zapreti okna, ki ga sam ni odprl
5. Ne more dostopati do strani v drugi domeni
6. Ne more zaščititi vsebine/slik pred prenosom

### Statične vs. dinamične strani
- **Statična** - pripravljena vnaprej (lahko čisti HTML ALI HTML+JS!)
- **Dinamična** - generirana na zahtevo (SSR na strežniku ali CSR na klientu)
- **SPA (Single Page Application)** - prazen HTML se dinamično napolni z JS na klientu

---

## 6. Ajax

### Zakaj Ajax? (Asynchronous JavaScript and XML)
Omogoča **asinhrono posodobitev dela strani** brez ponovnega nalaganja **cele** strani.

### Kaj Ajax potrebuje
JavaScript (drži skupaj operacijo) + DOM (struktura) + XMLHttpRequest (asinhrona komunikacija) + JSON/XML (format podatkov) + kompatibilen brskalnik in strežnik.

### JSON - JavaScript Object Notation
Berljiv format za izmenjavo podatkov. Razlike od JS objekta: stringi v **dvojnih** narekovajih, **brez komentarjev**.
```js
obj = JSON.parse(str);       // string → object
str = JSON.stringify(obj);   // object → string
```

### JS je single-threaded ⭐
Samo **ena** funkcija teče hkrati. Asinhrona funkcija se NE izvede takoj - čaka v vrsti (event loop). Zakasnitev v sinhroni funkciji **zakasni vse ostalo**.

### Koraki Ajax operacije
1. ustvari `XMLHttpRequest` → 2. konfiguriraj → 3. pošlji asinhrono → 4. strežnik odgovori → 5. callback → 6. posodobi DOM.

### Fetch API (DANES - vrača Promise)
```js
fetch('example.json')
.then(function(response) {
      if (!response.ok) throw new Error(response.status);
      return response.json();
})
.then(myJson => { document.getElementById('msg').innerHTML = myJson.sporocilo; })
.catch(function(error) { console.log('Napaka:', error); });
```

---

## 7. HTTP

### HyperText Transfer Protocol
Aplikacijski protokol tipa **zahteva/odgovor**, **brez stanja (stateless)** ⭐ - zahteve na isti povezavi niso avtomatsko povezane (za razliko od FTP, ki ima stanje).

### Verzije
HTTP/0.9 → HTTP/1.0 (MIME, headerji) → HTTP/1.1 (trajne povezave) → HTTP/2 (multiplexing) → HTTP/3 (QUIC+UDP).

### URL
Sintaksa: `protokol + strežnik [+ vrata] + pot [+parametri +fragment]`. `strežnik+vrata = "authority"`.

### URI = URL + URN ⭐
- **URI** - identificira vir po imenu ALI lokaciji ALI obojem (najsplošnejši)
- **URL** - po **lokaciji**; vsak URL je tudi URI
- **URN** - po **imenu**; je tudi URI

### Idempotentnost ⭐⭐ (zelo pogosto na izpitu)
Isti ukaz izveden večkrat **ne povzroči novih posledic** glede na prvo izvedbo.
- `GET`, `PUT`, `DELETE` - idempotentni
- `POST` - **ni** idempotenten
- Idempotenten ukaz LAHKO ima server-side posledice - pomeni ponovljivost brez DODATNIH sprememb, ne "brez učinka"

**Zakaj pomembno:** 1) retry logic (PUT varno ponoviš, POST lahko podvoji), 2) caching (GET/HEAD), 3) predvidljivost API-jev, 4) REST temelji na tem razlikovanju.

### GET vs. POST vs. PUT
| | GET | POST | PUT |
|---|---|---|---|
| Namen | preberi vir | ustvari nov vir | ustvari/zamenja vir |
| Podatki | v URL | v telesu | v telesu |
| Idempotenten | da | **ne** | da |
| Lokacijo določi | - | strežnik | odjemalec |

### Statusne kode ⭐
1xx Informational, 2xx Uspeh, 3xx Redirekcija, 4xx Uporabniška napaka, 5xx Strežniška napaka.
Pomembne: 200 OK, 201 Created, 301 Moved Permanently, 304 Not Modified, 400 Bad Request, 401 Unauthorized, 404 Not Found, 500 Internal Server Error.

### HTTPS
HTTP ni varen (MITM možen). **HTTPS = HTTP + TLS**, vrata 443. Zagotavlja: enkripcijo, integriteto, avtentikacijo.

---

## 8. Seje (Sessions)

### Osnovni problem
HTTP je brez stanja - strežnik mora SAM povezati zahteve istega uporabnika skozi čas.

### Rešitvi
A) vsaka zahteva vsebuje VSE podatke, ali B) unikatna **sejna oznaka**, ki na strežniku kaže na shranjene podatke.

### Identifikacija klienta ⭐
Sejno oznako lahko generira **samo strežnik**. Prva zahteva klienta NE vsebuje oznake (znak novega klienta).

### Prenašanje sejnih oznak
1. **integracija v URL** (nevarno, odsvetovano, ni standardizirano)
2. **piškoti (priporočeno)** - strežnik nastavi `Set-Cookie`, brskalnik avtomatsko doda piškot naprej

### Atributi piškotov ⭐
- **SameSite** (Strict/Lax/None)
- **Secure** - samo preko HTTPS
- **HttpOnly** - JavaScript nima dostopa (ključno proti XSS!)

Če je nastavljeno oboje `Expires` in `Max-Age`, zmaga **Max-Age**. Trajanje 0/negativno = takojšnje brisanje.

### URL rewriting vs. redirection vs. forwarding ⭐ (past - pogosto zamenjujejo na izpitu)

**1. URL rewriting (interna preoblikovanje URL-ja)**
Strežnik "za kulisami" preoblikuje en URL v drugega, preden ga obdela - brskalnik v naslovni vrstici še vedno vidi **prvotni** naslov, saj se vse zgodi na strežniku.
```
Uporabnik v brskalnik vpiše:      http://trgovina.si/izdelek/42
Strežnik interno preoblikuje v:   http://trgovina.si/prikazi.php?id=42
→ V naslovni vrstici ostane:      http://trgovina.si/izdelek/42
```
Primer iz predavanj: `http://www.xxx.com/working` → `http://www.xxx.com/nicer` (strežnik interno preslika "grd" URL v "lepšega", ali obratno). Uporablja se tudi za prenašanje sejne oznake v URL (`;sid=...`), ko piškotki niso na voljo.

**2. URL redirect (redirekcija - HTTP 3xx odgovor)**
Strežnik brskalniku **eksplicitno pove**, naj naredi **novo** zahtevo na drug naslov. Brskalnik to vidi - naslovna vrstica se **spremeni**, nastane **nova HTTP zahteva**.
```
Uporabnik obišče:                 http://old.com/alfa
Strežnik vrne:                     HTTP/1.1 301 Moved Permanently
                                    Location: http://new.com/beta
Brskalnik nato sam pošlje:         GET http://new.com/beta
→ V naslovni vrstici je zdaj:      http://new.com/beta
```
Tipična uporaba: preusmeritev po prijavi, preusmeritev s stare domene na novo, preusmeritev HTTP → HTTPS.

**3. URL forwarding (interno posredovanje zahteve)**
Strežnik zahtevo **interno preda naprej** drugi komponenti (npr. iz kontrolerja v pogled), počaka na rezultat in ga vrne, **kot da bi ga sam pripravil**. Brskalnik sploh ne ve, da se je to zgodilo - ni nove HTTP zahteve, naslovna vrstica se **ne spremeni**.
```
Uporabnik obišče:                 http://app.si/narocilo/potrdi
Kontroler interno posreduje na:   /WEB-INF/pogledi/potrditev.jsp (znotraj strežnika)
Rezultat se vrne uporabniku, kot da je prišel od prvotnega URL-ja
→ V naslovni vrstici ostane:       http://app.si/narocilo/potrdi
```

**Hitra razlika za izpit:**
| | Vidi brskalnik spremembo naslova? | Nova HTTP zahteva? | Kje se zgodi preslikava |
|---|---|---|---|
| **Rewriting** | ne | ne (isti request, samo drugačna interna pot) | na strežniku, pred obdelavo |
| **Redirect** | **da** | **da** (brskalnik pošlje novo zahtevo) | strežnik pošlje 3xx odgovor, brskalnik ukrepa |
| **Forward** | ne | ne | znotraj strežnika, med njegovimi komponentami (npr. MVC controller → view) |

### Varnostne grožnje
XSS (vrinjen `<script>`), CSRF (nehoteni request s tvojimi piškoti), MitM (nemogoč pri HTTPS+Secure), Session Fixation (vsiljen ID), Session Hijacking (ukraden ID).
Zaščita XSS: sanitizacija/encoding. Zaščita CSRF: CSRF žeton, SameSite, POST namesto GET za kritične operacije.

--- 

## 9. Strežniška stran

### Spletni strežnik
Odgovarja na zahteve, posluša privzeto na **vratih 80**. Top: Apache, nginx, Lighttpd.

### 3 možnosti za dinamično vsebino
1. zunanji program (npr. **CGI** - Common Gateway Interface, "skupni prehodni vmesnik", oz. cgi-bin) 2. interni interpreter (npr. **PHP** - PHP: Hypertext Preprocessor) 3. program = tudi web server (Node.js)

**JSP** (JavaServer Pages) in **PHP** (PHP: Hypertext Preprocessor) sta primera "template" jezikov, kjer se programska koda vgradi neposredno v HTML:
```jsp
<!-- halo.jsp -->
Zdravo, <%= urlencode(request.getParameter('ime')) %>
```
```php
<!-- halo.php -->
Zdravo, <?= urlencode($_REQUEST['ime']) ?>
```

### Node.js + Express + EJS
**EJS** = Embedded JavaScript (vgrajeni JavaScript) - priljubljen "template engine" (predlogovni pogon) za Node.js.
```js
app.set('view engine', 'ejs');
app.get('/', (req, res) => {
   const ime = req.query.name || 'World';
   res.render('index', { ime });
})
```
Proti XSS: `<%= encodeURIComponent(ime) %>` namesto surovega vstavljanja.

---

## 10. REST - Representational State Transfer (predstavitveni prenos stanja)

### Problem, ki ga REST rešuje
Spletne aplikacije morajo pogosto sodelovati med sabo - znotraj iste aplikacije, med različnimi aplikacijami iz iste domene ali celo iz **različnih** domen. Za to obstaja več tehnologij/arhitektur/filozofij:
- **RPC** (Remote Procedure Call - oddaljeni klic procedure)
- **SOAP** (Simple Object Access Protocol) z **WSDL** (Web Services Description Language) in **WS-\*** standardi
- **custom API** (po meri narejen vmesnik)
- **REST** (Representational State Transfer)

### Bistvo
REST je **filozofija/ideja**, kako naj se aplikacije **pogovarjajo** med sabo - REST NE govori o tem, kako naj aplikacija deluje ali je zasnovana navznoter (notranja arhitektura), ampak o tem, kakšna naj bo zasnova **navzven**, da je enostavno uporabna komurkoli (kateremukoli drugemu programu ali brskalniku).

Aplikacija tipa odjemalec-strežnik (client-server) temelji na sporočilih, ki so lahko razumljiva bodisi samo aplikacijski kodi, bodisi tudi drugim (tujim) programom. REST prenaša informacije o **možnih ukazih**, ne le o podatkih.

Ideja: **nič nas ne sili v uporabo REST-a**, je pa z njim veliko lažje našo aplikacijo povezati (integrirati) z drugimi aplikacijami/storitvami - ne samo z brskalnikom.

### Na kratko - 4 stebri REST-a
1. **Pomenska (semantic) uporaba** HTTP metod in HTTP statusnih kod - vsaka metoda/koda ima jasen, standarden pomen
2. **Stateless** (brez stanja) strežniki + informirani odjemalci
   a. Informirane povezave na možne akcije (glej HATEOAS spodaj)
   b. Neodvisne zahteve z vso potrebno vsebino (brez zanašanja na prejšnje zahteve)
3. **URI-ji kot struktura map** - intuitivna, drevesna oblika naslavljanja virov (npr. `/uporabniki/123/narocila/7`)
4. **Prenos podatkov** z XML ali JSON ali obema (poljubna oblika, dokler je dogovorjena)

### Pomenska uporaba HTTP metod ⭐
| Metoda | Pomen | Primer |
|---|---|---|
| GET | Preberi vir | `GET /uporabniki/123` |
| POST | Ustvari nov vir | `POST /uporabniki` |
| PUT | Popolnoma posodobi (zamenja) vir | `PUT /uporabniki/123` |
| PATCH | Delno posodobi vir | `PATCH /uporabniki/123` |
| DELETE | Izbriši vir | `DELETE /uporabniki/123` |

**💡 Za izpit (primer vprašanja #46):** primitivna RESTful storitev za dodajanje uporabnika: `POST /users`, telo zahteve vsebuje `"Mirko"` - NE v URL-ju kot parameter, ker gre za ustvarjanje novega vira brez vnaprej znanega identifikatorja (ID-ja); PRAVI URI vira (`/users/Mirko` ali `/users/123`) se določi šele, ko strežnik ustvari nov zapis.

### 6 vodilnih principov REST-a (Richardson / restfulapi.net) ⭐⭐
1. **Odjemalec–strežnik (Client-Server)**
   Uporabniški vmesnik in shranjevanje podatkov sta ločena - to izboljša prenosljivost uporabniškega vmesnika in skalabilnost strežniške komponente (lahko ju razvijamo/spreminjamo neodvisno).
2. **Brez stanja (Stateless)**
   Vsaka zahteva mora vsebovati **vse** potrebne podatke - strežnik si **ne zapomni** ničesar o prejšnjih zahtevah istega klienta. To je isti "stateless" princip kot pri HTTP na splošno.
3. **Predpomnjenje (Cacheable)**
   Odzivi strežnika morajo biti eksplicitno označeni kot predpomnjeni (cacheable) ali ne - za boljšo učinkovitost in manjšo obremenitev strežnika.
4. **Enoten vmesnik (Uniform Interface)**
   Standardiziran način dostopanja do virov - vedno preko istih HTTP metod (GET, POST, PUT, DELETE...), ne glede na to, kateri vir naslavljamo. To je "srce" REST arhitekture.
5. **Plastna arhitektura (Layered System)**
   Komponente so organizirane v plasteh (npr. klient → load balancer → API strežnik → baza) - vsaka plast vidi le neposredno sosednjo plast, ne ve, kaj je še globlje (npr. klient ne ve, ali komunicira neposredno s strežnikom ali preko posrednika).
6. **Koda na zahtevo (Code on Demand)** - *opcijsko, edini neobvezni princip*
   Strežnik lahko odjemalcu pošlje izvedljivo kodo (skripte, aplete) za razširitev funkcionalnosti na klientu (npr. pošiljanje JavaScript kode klientu).

### HATEOAS - Hypermedia As The Engine Of Application State
(Hipermedija kot gonilo stanja aplikacije)

Klient dostopa do spletne aplikacije **preko informacij v hipertekstu** (povezav) in ne potrebuje dodatnih vnaprejšnjih specifičnih znanj o API-ju, kot je to sicer značilno pri drugih tipih spletnih storitev (npr. SOAP, kjer moraš vnaprej poznati natančno strukturo klicev).

Uporaba HTTP ukazov ter zapis stanj in akcij v hipertekstu omogoča **rahlo sklopljenost (loose coupling)** med klientom in strežnikom, kar posledično omogoča lažji razvoj novih funkcionalnosti na strežniku, ki ne "rušijo" (ne pokvarijo) obstoječih klientov.

**Ključna ideja:** Vse možne akcije trenutnega stanja so vedno zapisane v trenutnem dokumentu (odgovoru); prehod med stanji aplikacije poteka **izključno preko povezav**, ki jih strežnik ponudi.

Primer - bančni račun (glej HTTP odgovor spodaj): ko je stanje pozitivno, strežnik v odgovoru ponudi povezave za `deposit` (vplačilo), `withdraw` (dvig), `transfer` (nakazilo) in `close` (zaprtje računa). Ko pa je stanje **negativno**, strežnik ponudi **samo** `deposit` - `withdraw` sploh ni med ponujenimi povezavami, ker trenutno stanje te akcije ne dopušča. Klientu torej **ni treba vnaprej vedeti**, katere akcije so na voljo - prebere jih neposredno iz odgovora.

```xml
GET /accounts/12345 HTTP/1.1
Host: bank.example.com
Accept: application/xml

************ odgovor (pozitivno stanje) ************
HTTP/1.1 200 OK
Content-Type: application/xml

<account>
    <account_number>12345</account_number>
    <balance currency="usd">100.00</balance>
    <link rel="deposit" href="https://bank.example.com/accounts/12345/deposit" />
    <link rel="withdraw" href="https://bank.example.com/accounts/12345/withdraw" />
    <link rel="transfer" href="https://bank.example.com/accounts/12345/transfer" />
    <link rel="close" href="https://bank.example.com/accounts/12345/close" />
</account>

************ ali (negativno stanje) ************
<account>
    <account_number>12345</account_number>
    <balance currency="usd">-25.00</balance>
    <link rel="deposit" href="https://bank.example.com/accounts/12345/deposit" />
</account>
```

### Povzetek REST-a
Čeprav REST temelji na stateless protokolu (HTTP), ima v svojem imenu "prenos **stanja**" (State Transfer) - govora je o **aplikacijskem stanju**, ki določa možne akcije v programu in ki se v celoti prenese na klienta v preprosti obliki povezav. Vsaka zahteva je torej **polno informirana** - vsebuje vse, kar klient potrebuje za naslednji korak.

REST je torej filozofija o tem, **kako naj bodo strežniški viri predstavljeni na klientu**, ne pravilnik o notranji implementaciji.

### Richardson Maturity Model (nivoji zrelosti REST API-ja)
Model, ki opisuje, kako "resnično RESTful" je neka storitev, glede na štiri nivoje (0–3):
- **Nivo 0** - en sam URI (endpoint), ena metoda (npr. samo POST) - kot "oddaljeni klic funkcije" preko HTTP
- **Nivo 1** - uporaba **virov** (resources) z lastnimi URI-ji (npr. `/uporabniki/123`), a še vedno ena sama metoda
- **Nivo 2** - pravilna, pomenska **uporaba HTTP metod** (GET, POST, PUT, DELETE) in statusnih kod
- **Nivo 3** - dodan **HATEOAS** - odgovori vsebujejo povezave na možne naslednje akcije (najvišji, "najbolj RESTful" nivo)

(vir: Martin Fowler, Richardson Maturity Model)

---

## 11. Razno (MVC, React, SEO, varnost)

### MVC - Model View Controller (model – pogled – krmilnik)
Arhitekturni vzorec za organizacijo kode v spletnih in programskih aplikacijah. Loči **podatke**, **uporabniški vmesnik** in **logiko**, da je razvoj bolj strukturiran, berljiv in vzdržljiv.

**Sestavni deli:**
- **Model (M)** - predstavlja poslovno logiko in dela s podatki (npr. dostop do baze, izračuni)
- **View (V), pogled** - predstavlja uporabniški vmesnik (kaj uporabnik dejansko vidi na zaslonu)
- **Controller (C), krmilnik** - posreduje med Modelom in Pogledom; upravlja dogodke in usmerja podatke

**🎯 Cilj:** ločevanje skrbi (**Separation of Concerns**) - vsaka komponenta ima jasno določeno, ozko odgovornost. To omogoča enostavnejše testiranje, razširljivost in lažje timsko delo (različni ljudje lahko delajo na Modelu, Pogledu in Krmilniku hkrati, brez da bi si stopali "na prste").

**Kako deluje MVC - potek komunikacije:**
1. Uporabnik sproži zahtevo (npr. klik gumba), ki pride do **Krmilnika (Controller)**
2. Krmilnik po prejemu zahteve pokliče ustrezno logiko v **Modelu**
3. Model obdela podatke in vrne rezultat
4. Krmilnik posreduje prejete podatke **Pogledu (View)**
5. Pogled vrne Krmilniku obliko, primerno za prikaz uporabniku
6. Krmilnik pošlje odgovor uporabniku

```
        1 zahteva              6 odgovor
   Uporabnik ────────► Controller (C) ────────► Uporabnik
                          │      ▲
                        2 │      │ 3 (rezultat)
                          ▼      │
                        Model (M)
                          
                        4 │      │ 5 (oblika za prikaz)
                          ▼      │
                        View (V)
```

**✅ Prednosti MVC:**
- Ločena odgovornost = bolj organizirana, berljiva koda
- Lažje testiranje in vzdrževanje (vsak del lahko testiraš posamezno)
- Primeren za spletne, namizne in mobilne aplikacije
- Povečana možnost ponovne uporabe kode (npr. isti Model za več Pogledov)

**❌ Slabosti MVC:**
- Za preproste aplikacije lahko prekompleksen (preveč "ceremonije" za majhen problem)
- Več začetnega učenja za nove razvijalce
- Zahteva dobro načrtovanje in disciplino pri organizaciji (sicer se meje med M/V/C zabrišejo)

**💡 Razlika REST vs. MVC (past na izpitu):** Če REST govori o **zunanji komunikaciji** (kako se aplikacije/sistemi med sabo pogovarjajo preko HTTP), MVC govori o **notranji zasnovi ene aplikacije** (kako je organizirana koda znotraj enega sistema). Nekatera ogrodja predvidevajo tudi dodatno povezavo Model → View neposredno (brez posredovanja Krmilnika), a osnovna ideja ločitve ostaja enaka.

### Frontend pristop: React + REST API
Sodoben pristop k spletnim aplikacijam pogosto obrne klasični server-side MVC na glavo:
```
Brskalnik (frontend, React) ⟷ Strežnik (backend, vrača JSON preko REST API-ja)
```
Brskalnik **generira** (ali "hidrira" - hydration, glej spodaj) uporabniški vmesnik iz komponent. Backend je zdaj samo **REST API**, ki vrača podatke (JSON), ne pa celih HTML strani.

**Component-based (komponentni) pristop** - razbijanje kompleksnosti:
- Velika stran se razdeli na manjše, samostojne **komponente** (npr. Header, Table, Form)
- Vsaka komponenta rešuje **manjši, obvladljiv** problem
- Komponente se sestavijo v drevo (celotna aplikacija = drevo komponent)

**Build & deployment proces (kako pride koda do uporabnika):**
1. Razvijalec piše kodo v **JSX** (JavaScript XML - sintaksa, ki meša JavaScript in HTML-podobne oznake)
2. Orodje za gradnjo (**Vite** ali **Webpack** - build tool/bundler) pretvori JSX v navaden JavaScript in ga združi v **bundle** (eno ali več optimiziranih `.js` datotek)
3. Bundle nastane **ob deploymentu** (ko razvijalec izvede `npm run build`)
4. Brskalnik nato samo naloži in izvede že pripravljeni bundle - sam ne razume JSX-a neposredno

**✅ Prednosti Reacta:**
- Razbijanje kompleksnosti problema (komponente)
- Dinamičen in odziven uporabniški vmesnik (UI)
- Razbremenjen strežnik (velik del dela opravi brskalnik)
- Build optimizacija (manjše, hitrejše datoteke za produkcijo)

**❌ Slabosti Reacta:**
- Večja kompleksnost same tehnologije (učna krivulja, orodja za gradnjo...)
- SEO in začetni čas nalaganja (ker je stran sprva "prazna", dokler se JS ne izvede) - rešujemo z **SSR (Server-Side Rendering)** + "hidracijo" (hydration - strežnik pošlje že izrisan HTML, React nato "oživi" interaktivnost nad njim)
- Frontend **ni skrit** (uporabnik lahko v brskalniku vidno vidi izvorno kodo/logiko)
- Overkill (pretiravanje) za enostavne aplikacije
- Hitro spreminjajoč se ekosistem (orodja in prakse se hitro menjajo)

### MVC (server-side) vs. React + REST - primerjava kompleksnosti ⭐
| | MVC (server-side) | React + REST |
|---|---|---|
| Kje je Controller + Model + View | vse na **strežniku** | Frontend (React) + Backend (API) - **ločeno** |
| Kaj dela backend | logika, podatki, **izris (render) HTML-ja** | poslovna logika, validacija, podatki (samo API, brez izrisa HTML-ja) |
| Kaj dela frontend | skoraj nič (samo prikaže že pripravljen HTML) | UI logika, stanje (state), routing (usmerjanje med "stranmi"), interakcije |
| Kje je kompleksnost | **centralizirana na backendu** | **razdeljena na oba dela** (frontend in backend) |

### "Zastarelo, slabo, odpisano"? - kritičen pogled na predloge (templates)
Ker strani, osnovane na predlogah (PHP, JSP, ASP...), omogočajo pisanje programske kode (scripting) neposredno znotraj HTML-ja, so programerji v praksi pogosto pisali **celotno kodo kar v njih**, brez uporabe slojev (layers) ali MVC vzorca. Posledično je bila koda nepregledna in nemogoča za vzdrževanje, saj je združila uporabniški vmesnik s poslovno logiko in podatkovnim slojem v eno samo neurejeno celoto.

**Ključno spoznanje:** Težava ni bila toliko v sami tehnologiji, kot v njeni **slabi uporabi**. Tudi mlajše, "anotirane" predloge ali komponente (npr. React) spet prinašajo svoje probleme (lahko postanejo kompleksne, nepregledne, krhke), če se uporabljajo nepremišljeno.

> Spreminjajo se ogrodja in jeziki - čas dokaže kvaliteto (dobre prakse ostajajo enake, ne glede na trenutno "modno" tehnologijo).

### HTML (Web) API-ji - pregled
Web API-ji so vnaprej pripravljene funkcionalnosti, ki jih **brskalniki** ponujajo spletnim razvijalcem za interakcijo z brskalnikom ali napravo. Na voljo so **neposredno znotraj brskalnika**, brez potrebe po dodatnih knjižnicah. Standardizirani so s strani **W3C** (World Wide Web Consortium) in **WHATWG** (Web Hypertext Application Technology Working Group).

Pomembnejši Web API-ji:
- **DOM API** (Document Object Model) - dostop in manipulacija HTML dokumenta
- **Web Storage API** - trajen `localStorage` (podatki ostanejo tudi po zaprtju brskalnika) in začasen `sessionStorage` (podatki izginejo ob zaprtju zavihka/okna) na strani odjemalca
- **Fetch API** - pošiljanje asinhronih HTTP zahtev (moderna zamenjava za XMLHttpRequest)
- **Geolocation API** - pridobi uporabnikovo geografsko lokacijo (z dovoljenjem uporabnika)
- **Canvas API** - omogoča risanje 2D grafike, animacij in vizualizacij neposredno v elementu `<canvas>`

### SEO - Search Engine Optimization (optimizacija za iskalnike)
Proces izboljševanja spletne strani, da se višje uvrsti v rezultatih iskalnikov (npr. Google) in s tem privabi več **organskega** (neplačanega) prometa.

**🎯 Cilj:** povečati vidnost spletne strani v rezultatih iskanja za relevantne ključne besede.

**🔍 Ključni elementi:**
- **On-page SEO** (na strani same) - vsebina, naslovi, meta oznake, struktura strani
- **Off-page SEO** (izven strani) - povezave od drugih strani (backlinki), aktivnost na družbenih omrežjih, splošen ugled
- **Tehnični SEO** - hitrost nalaganja strani, mobilna odzivnost (responsive design), pravilna indeksacija, zemljevid strani (sitemap)

**📈 Zakaj je SEO pomemben?** Približno 75 % uporabnikov ne klikne dalje od prve strani rezultatov v Googlu - več organskega prometa pomeni več priložnosti za prodajo, prijave in konverzije.

**Najboljše prakse:**
| ✅ On-page SEO | ✅ Off-page SEO |
|---|---|
| Ključne besede naravno v naslovih, podnaslovih, vsebini | Gradnja kakovostnih povratnih povezav (backlinkov) |
| Optimizirani meta opisi in naslovi strani | Aktivnost na družbenih omrežjih |
| Alt besedilo za slike | Objavljanje gostujočih člankov (guest posts) |
| Ustrezna struktura z uporabo pravih HTML značk | |

| ✅ Tehnični SEO | ❗ Napake, ki se jim izogibaj |
|---|---|
| Hitro dostopna stran (minimiziran CSS/JS, uporaba CDN) | Prekomerna uporaba ključnih besed ("keyword stuffing") |
| Prilagojena mobilnim napravam (responsive design) | Podvojena (duplicirana) vsebina |
| Uporaba `sitemap.xml` in `robots.txt` | Slaba struktura URL-jev (npr. `example.com/page?id=123`) |
| Omogočen HTTPS (SSL/TLS certifikat) | Manjkajoče meta oznake |

**SEO pojmi in metrike:**
| Pojem | Pomen |
|---|---|
| **Impressions** (prikazi) | Kolikokrat je bila stran prikazana v rezultatih iskanja (ne nujno kliknjena) |
| **CTR - Click-Through Rate** (stopnja klikov) | Delež uporabnikov, ki kliknejo povezavo izmed vseh, ki so jo videli. Formula: (kliki / prikazi) × 100 |
| **Organic Traffic** (organski promet) | Obiskovalci, ki pridejo na stran preko neplačanih rezultatov iskanja |
| **Bounce Rate** (stopnja zapustitve) | Delež uporabnikov, ki takoj zapustijo stran, ne da bi si ogledali še kaj drugega |
| **Conversion** (konverzija) | Delež/število obiskovalcev, ki naredijo želeno dejanje (nakup, prijava...). Formula: dejanja / organski obiskovalci |
| **Time on Page** (čas na strani) | Povprečni čas, ki ga uporabnik preživi na strani - višji čas pogosto pomeni bolj kakovostno vsebino |

### 3rd-party (tretje-strani) piškotki: od FLoC do Topics API
**Kaj je bil FLoC (Federated Learning of Cohorts, "zvezno učenje kohort")?**
- Razvrščal je uporabnike v skupine (**cohorts**, kohorte) na podlagi zgodovine brskanja
- Namen: ciljanje oglasov **brez** 3rd-party piškotkov
- Težave: kritike glede zasebnosti (sledenje, možna diskriminacija), kompleksnost, pomanjkanje podpore drugih brskalnikov → **ukinjen leta 2022**

**🆕 Kaj je Google Topics API?**
- Naslednik FLoC-a, del pobude **Privacy Sandbox** ("peskovnik zasebnosti")
- Brskalnik sledi **interesom (temam)** uporabnika, ne obiskanim stranem samim
- Teme se delijo z oglaševalci (npr. "Books", "Fitness", "Travel")
- **Lokalna obdelava** - podatki se obdelajo v brskalniku, brez pošiljanja zgodovine brskanja ali identitete uporabnika kamorkoli

**Kako deluje Topics API?**
1. Uporabnik brska po spletu
2. Brskalnik lokalno shrani do 3 interesne teme na teden
3. Pri oglasni zahtevi brskalnik pošlje te teme (ne zgodovino!) obiskani spletni strani
4. Teme se menjajo vsake 3 tedne, brez sledenja posamezniku

**Zakaj je boljši od FLoC-a?** Večja zasebnost (brez ID-jev, brez "skupin"), uporabniški nadzor (možno je videti in odstraniti teme), enostavnost (teme so jasne in razumljive), manj tveganj (ni profiliranja preko več spletnih mest).

**🎯 Ključni cilj:** ciljano oglaševanje **brez** sledenja uporabniku kot posamezniku - ravnotežje med zasebnostjo in učinkovitostjo oglaševanja.

### Nevarnosti uporabe sej (varnost)
Piškoti s sejno oznako so varnostno kritični v smislu kraje oz. nepooblaščenega dostopa do vsebine piškota. Obstaja mnogo načinov za pridobivanje sejnega identifikatorja (ID-ja):
1. **XSS (Cross-Site Scripting)** - mogoče v slabo zaščiteni aplikaciji
2. **CSRF (Cross-Site Request Forgery)** - mogoče v slabo zaščiteni aplikaciji
3. **MitM (Man-in-the-Middle)** - nemogoče pri uporabi HTTPS in atributa Secure
4. **Session Fixation** (podtikanje) - napadalec uporabniku podtakne svoj ID
5. **Session Hijacking** (ugrabitev) - napadalec uporabniku ukrade njegov obstoječi ID iz brskalnika

*(Poseben, poglobljen predmet na temo varnosti sledi v tretjem letniku!)*

### Cross Site Scripting (XSS) - skriptanje med spletnimi mesti
Napadalec lahko na strežnik pošlje zlonamerno kodo preprosto tako, da jo v okviru (sicer navadnih) podatkov obda z značko `<script>`. Zato **NIKOLI** ne smemo prikazati nezavarovanega uporabniškega besedila. Zavarovanje je možno bodisi ob sprejemu podatkov, bodisi ob njihovem prikazu. Uporabimo lahko:
a) **sanitizacijo** - izločitev "nevarnih" značk (`"<script>...</script>"` → `""`), in/ali
b) **encoding** (kodiranje) - (pre)kodiranje uporabniške vsebine (`"<script>"` → `"&lt;script&gt;"`)

| Slaba praksa | Dobra praksa |
|---|---|
| `oglas.naslov` | `DOMPurify.sanitize(oglas.naslov)` |
| `<%= $_REQUEST["abc"] %>` | `<%= urlencode($_REQUEST["abc"]) %>` |
| `<%= ime %>` | `<%= encodeURIComponent(ime) %>` |

### Cross Site Request Forgery (CSRF) - ponarejanje zahtev med spletnimi mesti
Ob obisku napadalčeve spletne strani nehote sprožimo zahtevo na (drug, legitimen) strežnik, ki ji naš brskalnik **normalno pridoda naše piškote** (ker to počne avtomatsko za vsako zahtevo na to domeno). Napadalec sam torej ne vidi naših sejnih podatkov, lahko pa proži zahteve **v našem imenu**, ne da bi se sploh zavedali.

**Zaščita pred CSRF:**
1. **CSRF žeton (token)** - potrebna skrivnost, ki je napadalec ne more uganiti/pridobiti
2. **SameSite piškot** nastavitev (Strict ali vsaj Lax)
3. Če že uporabljamo SameSite Lax, potem uporabimo **POST namesto GET** za kritične operacije - idempotenten GET naj ne bi imel škodljivih posledic, POST pa v načinu Lax sploh ni dovoljen za zahteve s tretjih strani

### WebAssembly (Wasm)
Včasih JavaScript ni dovolj - zahteva preveč časa za nalaganje, parsanje in prevajanje, oziroma je preprosto prepočasen za zahtevne naloge (3D igre, virtualna resničnost/VR, računalniški vid). Takrat potrebujemo **WebAssembly (Wasm)**.

WebAssembly je dejansko **univerzalni izvajalni format**, ki ga brskalnik podpira enako, kot podpira JavaScript.

Prvotno je bil zamišljen kot način za uporabo **C** in **C++** kode v brskalniku, danes pa obstajajo prevajalniki tudi za večino drugih programskih jezikov.

**Pomembno:** Wasm **ni nadomestilo** za JavaScript, ampak ga **dopolnjuje**. Wasm recimo nima direktnega dostopa do DOM-a (Document Object Model) - do njega mora dostopati posredno, preko JavaScripta.

---

## 12. Banka izpitnih vprašanj z odgovori

> To so vsa vprašanja iz `izpitna_vprasanja.md` s pravilnimi odgovori in kratko razlago. Uporabi jih za hitro samopreverjanje pred izpitom.

**1. JavaScript kodo lahko zapišemo v:** → **c) a+b** (tako v `<script>` kot v event atributu, npr. `onclick="..."`)

**2. Element `<sheet>` sodi v:** → **d) nič od tega** (ne obstaja tak HTML/CSS/JS element - trik vprašanje)

**3. Kje lahko uporabimo HTML element `<style>`?** → **a) `<head>`** (formalno spada v head, čeprav ga brskalniki pogosto tolerirajo tudi drugje)

**4. Znotraj katerega HTML elementa lahko uporabimo `<script>`?** → **d) `<head>` ali `<body>`**

**5. HTML element z glavnim naslovom poglavja je:** → **c) `<h1>`**

**6. Katera beseda je hkrati lahko ime elementa in ime atributa?** → **a) style** (`<style>` element in `style=""` atribut)

**7. Kateri HTML element je namenjen ustvarjanju povezav?** → **a) `<a>`**

**8. Kaj lahko spremeni vsebino HTML elementa?** → **b) JS** (CSS spreminja izgled, ne vsebine; HTML samo definira, ne "spreminja" samega sebe med izvajanjem)

**9. V katerem elementu hranimo vso vsebino HTML dokumenta?** → **a) `<html>`** (korenski element vsebuje `<head>` in `<body>`)

**10. Kako JavaScript najenostavneje spremeni barvo pisave?** → **a) spremeni stil** (`element.style.color = ...`)

**11. Naštej 3 načine dodajanja CSS ukazov v HTML:** → 1) zunanja `.css` datoteka z `<link>`, 2) `<style>` v `<head>`, 3) inline `style=""` atribut

**12. Kaj minimalno potrebujemo za izdelavo responsive spletne strani?** → **a) CSS** (Bootstrap/JS sta pripomočka, ne nujnost - čisti CSS z media queries zadostuje)

**13. Kaj lahko spremeni CSS?** → **c) vidljivost elementa** (CSS lahko z `display`/`visibility` skrije/prikaže element; vsebine ne spreminja)

**14. Glavna prednost zapisa CSS pravil v ločeni datoteki:** → **c) konsistentno oblikovanje** (eno mesto za vse strani)

**15. Kaj določa CSS selektor?** → **d) omogoča popoln nadzor nad dokumentom** (izbira, kateri elementi se stilizirajo)

**16. Kaj velja za JavaScript?** → **d) Omogoča popoln nadzor nad dokumentom.** (ne nad računalnikom - glej omejitve JS)

**17. DOM je:** → **a) razred/API za delo s HTML** (natančneje: W3C standard/API za delo z (X)HTML/XML dokumentom kot drevesom)

**18. Dinamična spletna stran je:** → **d) vse našteto je res** (prilagojena uporabniku, ustvarjena na zahtevo, lahko kombinacija statičnih elementov + JS)

**19. Ideja responsive HTML oblikovanja je:** → **a) isti HTML za vse naprave** (fluidno se prilagaja, ne generira posebnih verzij)

**20. Kaj velja za `<div>` element?** → **a) Zasede celotno okno (širino)** (privzeto block-level element, 100% širine starša)

**21. UTF-8/UTF-16 trditve:** → pravilno: **b) UTF-16 vsebuje črke, ki jih ni v UTF-8** je NAROBE (oba pokrivata cel Unicode) - pravilna trditev je **d) UTF-8 porabi vsaj 8 bitov na črko, UTF-16 pa vsaj 16** (spremenljiva dolžina, ne fiksna)

**22. Kako komunicirata brskalnik B in strežnik S?** → **a) B-S** (klient vedno sam sproži zahtevo; ni B-S-B kroga v enem HTTP ciklu)

**23. Kaj je slabost DOM?** → **d) Počasno nalaganje dokumenta** (ker prebere cel dokument v pomnilnik pred uporabo - glej DOM vs SAX)

**24. Kaj velja za atributa class in id?** → **a) En element lahko pripada več razredom, id pa samo enemu elementu**

**25. Kaj velja za style atribut v okviru značke?** → **a) Prevlada nad ostalimi pravili** (najvišja specifičnost)

**26./29. XML/XHTML trditve (P/N):**
- a. HTML upošteva 5 XML pravil (dobro oblikovan) → **N** (navaden HTML tega ne zahteva, XHTML pa)
- b. XHTML je XML skladen s HTML shemo → **P**
- c. XHTML je HTML z dodanimi uporabniškimi označbami → **N** (XHTML ne dodaja novih značk, samo strožjo XML sintakso)
- d. XSL je popolno nadomestilo za XML → **N** (XSL transformira XML, ni nadomestilo)
- e. DOM je drugo ime za XML format → **N** (DOM je API/model, ne format)

**27./47. Za statično HTML stran velja:** → **b) Strežnik jo ima predpomnjeno, brskalniki jo (zaradi JS) lahko prikažejo različno** (statična ne pomeni brez JS!)

**28./48. Dinamično obnašanje spletne strani:** → **a) lahko dosežemo ali z JS na klientu ali s sprotno izdelavo na strežniku**

**30. Kateri HTTP ukaz omogoča izdelavo zabeležk (bookmark)?** → **a) GET** (ker vsebuje vse podatke v URL-ju, ga lahko shraniš/deliš)

**31. Kateri HTTP ukaz lahko briše podatke na strežniku?** → **d) nič od naštetega** - ker našteti (GET, GET+POST, POST) niso namenjeni brisanju; pravi ukaz je DELETE, ki ni med opcijami

**32. Pri MVC zasnovi bo model verjetno spisan v:** → **c) Java** (poslovna logika/podatki - backend jezik, ne HTML/CSS/PHP predloga)

**33. Iz `https://primer.com/app/svpg?abc=Kdo+ve%3F` je razvidno:** → **b) uporabljen je URL escaping** (`%3F` = kodiran `?`, `+` = presledek)

**34. Iz `https://primer.com:1234/app/svpg/?abc=Kdo&kaj=abc` je razvidno:** → **b) poslana sta bila 2 parametra** (`abc` in `kaj`)

**35. Obdelava podatkov spada v:** → **b) model**

**36. Kdo generira sejno oznako?** → **a) strežnik**

**37. Strežnik vodi s piškoti po eno sejo za vsak/o:** → **c) brskalnik** (piškot je vezan na brskalnik, ne na računalnik ali posamezno HTTP povezavo)

**38. REST** = **Representational State Transfer**

**39. SEO** = **Search Engine Optimization** (optimizacija za iskalnike)

**40. CDN** = **Content Delivery Network**

**41. URL** = **Uniform Resource Locator**

**42. Trditve o sejah (P/N):**
- a. Ime sejnih oznak je standardizirano "SESSIONID" → **N** (ni standardizirano, vsak framework uporabi svoje ime, npr. `JSESSIONID`, `PHPSESSID`)
- b. Sejna oznaka vsebuje IP klienta → **N** (samo naključen/unikaten ID)
- c. Seja ni edini način za časovno povezavo zahtev → **P** (lahko tudi vsi podatki v vsaki zahtevi)
- d. Sejne podatke lahko hrani tudi brskalnik → **P** (localStorage, cookies)
- e. Brskalnik lahko s piškoti odpre več sej na isti strežnik → **N** (piškot je 1 na brskalnik/domeno/pot)
- f. Seja je način ohranjanja podatkov po zaključku zahteve → **P**

**43. Trditve o piškotih (P/N):**
- a. Piškote pošilja brskalnik strežniku → **P** (pri vsaki naslednji zahtevi)
- b. Brez piškotov ni seje → **N** (obstaja alternativa: URL rewriting)
- c. Piškoti so tekstovna informacija → **P**
- d. Pot piškota določa lokacijo piškota v brskalniku → **N** (pot določa, za katere URL-je na strežniku velja, ne kje je shranjen v brskalniku)
- e. Piškot je lahko omejen bolj kot le z domeno → **P** (tudi s potjo/path)
- f. Vsak piškot vsebuje sejno oznako → **N** (samo poseben "sejni" piškot jo vsebuje)

**44. Za idempotentno HTTP zahtevo velja, da:** → **c) lahko spremeni strežnik** (idempotentnost ≠ brez učinka, pomeni ponovljivost brez DODATNIH sprememb)

**45. Koliko piškotov lahko dobimo ob enem obisku spletne strani?** → **a) nič ali več (≥0)**

**46. Primitivna RESTful storitev za dodajanje uporabnika uporabi zahtevo oblike:** → **d) POST /users, "Mirko" v telesu zahteve** (ustvarjanje novega vira brez vnaprej znanega ID-ja → POST na kolekcijo, podatki v telesu)

**49. Kdo bo odgovoril na AJAX ukaz?** → **a) Strežnik** (Ajax pošlje zahtevo strežniku, ta vrne odgovor)

**50. Česa AJAX ne potrebuje?** → **c) JSON** (AJAX prvotno pomeni "in XML" - JSON je pogosta, a ne nujna alternativa; DOM, JS in XMLHttpRequest so nujni)

**51. AJAX zahteva:** → **d) je nujna za izdelavo dinamičnih strani** - *(previdno: to vprašanje ima nerodno formulacijo v izvirniku; smiselni odgovor je, da AJAX omogoča dinamično posodabljanje brez ponovnega nalaganja cele strani - ni edini način, a je pogosto uporabljen zanj)*

**52. Kaj ni tipična zasnova spletnega strežnika?** → **d) Vse je mogoče** *(oz. glede na kontekst: strežnik lahko zaganja druge programe, jih interpretira ali je del aplikacije - vse tri so tipične zasnove, zato "d" pravi, da so vse mogoče)*

**53. Označi 4 temeljne principe REST spletnih storitev:** → **a) univerzalen zapis prehodov med stanji (HATEOAS)**, **c) uporaba zgolj idempotentnih metod (kjer smiselno)**, **e) uporaba virov preko URI**, **g) namenska uporaba HTTP metod**, **i) uporaba HTTP protokola**, **j) prenos podatkov v poljubno obliko** - (izbrati je treba 4; ključni so: **e, g, i, j** - URI za vire, pomenska HTTP raba, HTTP protokol, poljubna oblika prenosa podatkov)

**54. Kaj od naštetega ne sodi med ostale tri?** → **b) JSX** (PHP, ASP.NET in Java so strežniški/programski jeziki oz. ogrodja za backend; JSX je sintaksa za frontend/React)

**55. Zakaj HTTP protokol ne vzdržuje sejnih podatkov?** → **b) Ker je to odstopanje od osnovnega namena protokola** (HTTP je namenoma stateless po zasnovi)

**56. Kaj ni ukaz v HTTP protokolu?** → **c) ADD** (ne obstaja; TRACE, PUT, HEAD so pravi ukazi)

**57. Kje se hrani piškot?** → **d) Na klientu** (v brskalniku)

**58. Idempotentni HTTP ukaz:** → **a) lahko spremeni strežnik** (glej idempotentnost zgoraj)

**59. Kaj velja za piškote s sejno oznako?** → **b) Nič posebnega, so piškoti kot vsi drugi** (razen po vsebini/namenu, tehnično enaki drugim piškotom)

**60. Kaj je naloga HTTP protokola?** → **c) Izdelava sporočila za pošiljanje** (HTTP je aplikacijski nivo - oblikuje sporočilo; razbijanje na pakete/usmerjanje je naloga nižjih nivojev - TCP/IP)

**61. Dinamično spletno stran lahko ustvarimo na naslednje načine (možnih več):** → **a) s programom v specializiranem programskem jeziku (PHP/JSP)**, **b) s programom v splošnem programskem jeziku (Node.js)**, **c) s spletnim strežnikom (interni interpreter)**

**62. Iz `https://primer.com/app/svpg?abc=Kdo+ve%3F` je razvidno (možnih več):** → **a) stran svpg pričakuje (vsaj) parameter abc**, **c) uporabljena je metoda GET** (parametri v URL = GET), **d) stran svpg bo vrnila dinamični odziv** (ker procesira parameter)

**63. Kaj ni temelj REST arhitekture?** → **b) piškoti** (REST je stateless - piškoti kot mehanizem seje nasprotujejo temu principu; temelji so hipertekst, HTTP, URI)

**64. Izberi pravilno trditev:** → **b) Zahtevo ustvari klient, odgovor pripravi strežnik**

**65. Zakaj potrebujemo sejni mehanizem?** → **b) Da lahko strežnik razpozna istega klienta** (poveže zaporedne zahteve istega uporabnika)

**66. Kako preprečujemo Cross-Site-Scripting napade?** → **d) S procesiranjem (sanitizacijo/encodingom) uporabniških vsebin** (nikoli ne prikaži nezavarovanega uporabniškega vnosa)

**67. Kaj so pomembnejši kriteriji SEO (možnih več)?** → **b) semantičnost strani**, **d) dobra arhitektura strani**, **e) posodobljenost strani**, **f) zunanje/povratne povezave (backlinki)**, **g) dodatni strukturirani podatki** (lepa oblikovnost sama po sebi ni SEO kriterij)

**68. Pravilne trditve o sejah:** → **a) Vsaka zahteva mora vsebovati sejno oznako ali vse potrebne podatke** (glej dve rešitvi A/B), **d) Sejne oznake so alternativa prepošiljanju vseh preteklih podatkov**, **e) Če uporabljena, mora biti sejna oznaka prisotna v vsaki klientovi zahtevi** - *(b in c so napačne: dva strežnika si praviloma NE delita iste oznake, piškoti niso edini način - obstaja tudi URL)*

**69. Kje se prvič pojavi sejna oznaka?** → **c) V prvem odgovoru strežnika** (strežnik jo ustvari in pošlje ob prvi zahtevi klienta)

**70. Kaj pomeni, če ima piškot nastavljen atribut HttpOnly?** → **d) Da ga JavaScript ne more prebrati**

**71. Zakaj so pomembni pojmi URL rewriting, redirection in forwarding?** → **a) Ker omogočajo preslikavo med URL-ji** (različni načini preusmerjanja/preoblikovanja naslovov)

**72. Kdo je zadolžen za ustvarjanje sejnih oznak?** → **a) strežnik**

**73. Pravilne trditve o HTTP metodah:** → **b) Vsak URL je tudi URI** (glej URI=URL+URN), **d) Idempotentnost GET ukaza je odvisna od programiranja strežnika** (teoretično bi GET lahko implementiral neidempotentno, čeprav ne bi smel) - *(a, c, e, f so napačne: POST NI idempotentna; ne vsak odgovor ima telo (npr. 204); ni nujno browser-only (lahko tudi drug program/API klient); ni "100 OK" statusne kode - pravilna je "200 OK")*

---

## Hitri povzetek najpogostejših "past" vprašanj

| Past | Pravilen odgovor |
|---|---|
| HTML je programski jezik? | **NE** - je označevalni (markup) jezik |
| Ali GET lahko spremeni strežnik? | Teoretično da (odvisno od implementacije), a NE BI smel - po naravi je idempotenten |
| Ali je POST idempotenten? | **NE** |
| Kdo generira sejno oznako? | **VEDNO strežnik**, nikoli klient/brskalnik |
| Kje se piškot hrani? | **Na klientu** (v brskalniku) |
| HttpOnly atribut | Prepreči **JavaScript** dostop do piškota (ne omejuje http/https) |
| REST vs. MVC | REST = zunanja komunikacija med aplikacijami; MVC = notranja zasnova ene aplikacije |
| DOM vs. SAX | DOM = drevo v pomnilniku (počasno za velike datoteke); SAX = dogodkovno, ne da se vrniti nazaj |
| var vs. let | var = funkcijski doseg + duplicira se lahko; let = blokovni doseg, brez podvajanja |
| URL rewriting vs. redirect vs. forward | rewriting = interno preimenovanje; redirect = brskalnik gre na NOV naslov; forward = strežnik interno preusmeri, brskalnik ne opazi |

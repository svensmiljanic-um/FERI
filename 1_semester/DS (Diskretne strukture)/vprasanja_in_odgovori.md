# Vprašanja in odgovori – Diskretna matematika

## 1. SKLOP: Izjavni račun, logika in sklepanje

**1. S pomočjo pravilnostne tabele dokažite eno od De Morganovih pravil!**

Dokažimo pravilo: $\neg(p \wedge q) \sim \neg p \vee \neg q$.

Stestiramo resničnostne vrednosti za vse kombinacije izjav $p$ in $q$:

| p | q | p∧q | ¬(p∧q) | ¬p | ¬q | ¬p∨¬q |
|---|---|-----|--------|----|----|-------|
| 1 | 1 | 1   | 0      | 0  | 0  | 0     |
| 1 | 0 | 0   | 1      | 0  | 1  | 1     |
| 0 | 1 | 0   | 1      | 1  | 0  | 1     |
| 0 | 0 | 0   | 1      | 1  | 1  | 1     |

Ker sta stolpca za $\neg(p \wedge q)$ in $\neg p \vee \neg q$ popolnoma identična v vseh vrsticah, je ekvivalentnost dokazana.

*(Opomba: Drugo De Morganovo pravilo je $\neg(p \vee q) \sim \neg p \wedge \neg q$.)*

---

**2. Zapišite pogojni sklep in redukcijo na absurd in ju dokažite!**

**Pogojni sklep (PS):** Če želimo dokazati zaključek v obliki implikacije $C \Rightarrow D$, lahko izjavo $C$ začasno dodamo med predpostavke in dokažemo le zaključek $D$.

$$\text{Če } A_1, A_2, \dots, A_k, C \models D, \text{ potem } A_1, A_2, \dots, A_k \models C \Rightarrow D$$

*Dokaz:* Po definiciji veljavnosti sklepa je izraz $(A_1 \wedge \dots \wedge A_k \wedge C) \Rightarrow D$ tavtologija. Z uporabo zakonov izjavnega računa jo preoblikujemo:

$$\neg(A_1 \wedge \dots \wedge A_k \wedge C) \vee D \sim \neg(A_1 \wedge \dots \wedge A_k) \vee \neg C \vee D$$

Združimo zadnja dva člena $\neg C \vee D \sim C \Rightarrow D$:

$$\neg(A_1 \wedge \dots \wedge A_k) \vee (C \Rightarrow D) \sim (A_1 \wedge \dots \wedge A_k) \Rightarrow (C \Rightarrow D)$$

Ker je dobljeni izraz tavtologija, po definiciji velja $A_1, A_2, \dots, A_k \models C \Rightarrow D$.

**Redukcija na absurd (RAA):** Če želimo dokazati zaključek $B$, zanikano obliko zaključka ($\neg B$) začasno dodamo k predpostavkam in izpeljemo poljubno protislovje (neresnično izjavo $0$, npr. $C \wedge \neg C$).

$$\text{Če } A_1, A_2, \dots, A_k, \neg B \models 0, \text{ potem } A_1, A_2, \dots, A_k \models B$$

*Dokaz:* Iz predpostavke vemo, da je $(A_1 \wedge \dots \wedge A_k \wedge \neg B) \Rightarrow 0$ tavtologija. Ker implikacija ob desni strani $0$ zahteva, da je tudi leva stran enaka $0$, velja $A_1 \wedge \dots \wedge A_k \wedge \neg B \sim 0$. To preoblikujemo:

$$\neg(A_1 \wedge \dots \wedge A_k \wedge \neg B) \sim 1 \Rightarrow \neg(A_1 \wedge \dots \wedge A_k) \vee B \sim 1 \Rightarrow (A_1 \wedge \dots \wedge A_k) \Rightarrow B \sim 1$$

Ker je izraz tavtologija, je sklep logično pravilen.

---

**3. Pojasnite, čemu je enakovredna negacija izjave $\forall x : P(x)$.**

Negacija univerzalnega kvantifikatorja se prevede v eksistenčni kvantifikator zanikane lastnosti:

$$\neg(\forall x : P(x)) \sim \exists x : \neg P(x)$$

*Pojasnilo:* Trditev "Vsi elementi imajo lastnost $P$" je neresnična natanko tedaj, ko "Obstaja vsaj en element, ki lastnosti $P$ nima".

---

**4. Ekvivalentnosti izjav asociativnost, absorbcija, idempotentnost in komutativnost zapišite s simboli!**

**Asociativnost:**
- $(p \wedge q) \wedge r \sim p \wedge (q \wedge r)$
- $(p \vee q) \vee r \sim p \vee (q \vee r)$

**Absorbcija (vpijanje):**
- $p \wedge (p \vee q) \sim p$
- $p \vee (p \wedge q) \sim p$

**Idempotentnost:**
- $p \wedge p \sim p$
- $p \vee p \sim p$

**Komutativnost:**
- $p \wedge q \sim q \wedge p$
- $p \vee q \sim q \vee p$

---

**5. Kaj je sklep in kaj je njegov dokaz?**

**Sklep** je strukturiran nabor izjav, ki ga sestavlja končna množica predpostavk (premis) $\mathcal{A} = \{A_1, A_2, \dots, A_k\}$ in izjava $B$, ki predstavlja zaključek (konkluzijo). Shematično ga zapišemo kot: $A_1, A_2, \dots, A_k \models B$. Sklep je logično pravilen (veljaven) natanko tedaj, ko je zaključek $B$ resničen v vseh interpretacijah, kjer so resnične vse predpostavke hkrati.

**Dokaz sklepa** je končno zaporedje izjav $B_1, B_2, \dots, B_m$, kjer je zadnja izjava enakovredna zaključku ($B_m \sim B$). Za vsako izjavo $B_i$ v zaporedju mora veljati ena izmed naslednjih alinej:
- $B_i$ je ena izmed predpostavk ($B_i \in \mathcal{A}$).
- $B_i$ je logična tavtologija.
- $B_i$ je enakovreden kakšnemu izmed prejšnjih korakov ($B_i \sim B_j$ za $j < i$).
- $B_i$ je dobljen iz predhodnih členov zaporedja z uporabo veljavnih pravil sklepanja (npr. Modus Ponens).

---

**6. Zapišite 5 enostavnih sklepov in enega izmed njih dokažite!**

- Modus Ponens (MP): $A, A \Rightarrow B \models B$
- Modus Tollens (MT): $\neg B, A \Rightarrow B \models \neg A$
- Disjunktni Silogizem (DS): $\neg A, A \vee B \models B$
- Hipotetični Silogizem (HS): $A \Rightarrow B, B \Rightarrow C \models A \Rightarrow C$
- Poenostavitev (Po): $A \wedge B \models A$
- Pridružitev (Pr): $A \models A \vee B$

**Dokaz za Poenostavitev (Po):** Preverimo, ali je izraz $(A \wedge B) \Rightarrow A$ tavtologija:

$$(A \wedge B) \Rightarrow A \sim \neg(A \wedge B) \vee A \sim \neg A \vee \neg B \vee A \sim (\neg A \vee A) \vee \neg B \sim 1 \vee \neg B \sim 1$$

Ker smo s transformacijami dobili konstanto $1$, je izraz tavtologija in sklep je veljaven.

---

**7. Izjava $\neg\exists x : (P(x) \Rightarrow Q(x))$ je enakovredna izjavi:**

Naredimo korake negacije:

$$\neg\exists x : (P(x) \Rightarrow Q(x)) \sim \forall x : \neg(P(x) \Rightarrow Q(x))$$

Ker vemo, da je $\neg(A \Rightarrow B) \sim A \wedge \neg B$, dobimo končni izraz:

$$\forall x : (P(x) \wedge \neg Q(x))$$

---

**10. Zapišite in dokažite sklepa Modus Ponens in Disjunktni Silogizem!**

**Modus Ponens (MP):** $A, A \Rightarrow B \models B$

*Dokaz:* Preverimo izraz $(A \wedge (A \Rightarrow B)) \Rightarrow B$:

$$A \wedge (\neg A \vee B) \Rightarrow B \sim (A \wedge \neg A) \vee (A \wedge B) \Rightarrow B \sim 0 \vee (A \wedge B) \Rightarrow B \sim$$
$$(A \wedge B) \Rightarrow B \sim \neg(A \wedge B) \vee B \sim \neg A \vee \neg B \vee B \sim \neg A \vee 1 \sim 1 \quad (\text{tavtologija})$$

**Disjunktni Silogizem (DS):** $\neg A, A \vee B \models B$

*Dokaz:* Preverimo izraz $(\neg A \wedge (A \vee B)) \Rightarrow B$:

$$(\neg A \wedge A) \vee (\neg A \wedge B) \Rightarrow B \sim 0 \vee (\neg A \wedge B) \Rightarrow B \sim (\neg A \wedge B) \Rightarrow B \sim$$
$$\neg(\neg A \wedge B) \vee B \sim (A \vee \neg B) \vee B \sim A \vee (\neg B \vee B) \sim A \vee 1 \sim 1 \quad (\text{tavtologija})$$

---

**37. & 38. Kako se znebimo / kako dodamo kvantifikator v predikatnem računu?**

**Odstranjevanje kvantifikatorjev (specializacija / instanciacija):**
- Univerzalna specializacija (UI): Iz $\forall x : P(x)$ izpeljemo $P(c)$ za poljuben element $c$ domene.
- Eksistenčna specializacija (EI): Iz $\exists x : P(x)$ izpeljemo $P(c)$, kjer je $c$ povsem nov (še neuporabljen) simbol za element, za katerega lastnost velja.

**Dodajanje kvantifikatorjev (generalizacija):**
- Univerzalna generalizacija (UG): Če dokažemo $P(c)$ za popolnoma splošen in poljuben element $c$, lahko zaključimo $\forall x : P(x)$.
- Eksistenčna generalizacija (EG): Če velja $P(c)$ za nek specifičen znan element $c$, lahko zaključimo $\exists x : P(x)$.

## 2. SKLOP: Deduktivne teorije in matematična indukcija

**4. Kdaj je teorija protislovna, neprotislovna in polna?**

Naj bo deduktivna teorija $T = (\mathcal{E}, \mathcal{I})$, kjer je $\mathcal{E}$ množica vseh izjav, $\mathcal{I}$ pa množica izrekov (dokazljivih izjav):

- **Protislovna:** Če v njej obstaja vsaj ena izjava $e \in \mathcal{E}$, za katero velja, da sta hkrati $e$ in njena negacija $\neg e$ izreka teorije ($e \in \mathcal{I} \wedge \neg e \in \mathcal{I}$).
- **Neprotislovna:** Če za vsako izjavo $e \in \mathcal{E}$ velja, da je največ ena izmed izjav $e$ ali $\neg e$ izrek teorije.
- **Polna:** Če za vsako izjavo $e \in \mathcal{E}$ velja, da je natanko ena izmed izjav $e$ ali $\neg e$ izrek teorije.

---

**20. Kaj je indukcijska posplošitev v induktivnem razredu $In(B, P)$?**

Indukcijska posplošitev je metoda, s katero dokažemo, da neka lastnost $Q$ velja za vse elemente induktivno definiranega razreda $In(B, P)$. Sestoji iz dveh korakov:
- **Baza (izvirni korak):** Pokažemo, da imajo vsi osnovni elementi iz baze $B$ lastnost $Q$.
- **Indukcijski korak:** Pokažemo, da vsa operacijska pravila iz množice $P$ ohranjajo lastnost $Q$. To pomeni, da če imajo elementi-vstopi lastnost $Q$, jo bo imel tudi element, ki ga pravilo iz njih ustvari.

---

**41. Kaj je matematična indukcija?**

Matematična indukcija je dokazovalni postopek za preverjanje resničnosti trditve $P(n)$ za vsa naravna števila $n \ge n_0$. Sestoji iz dveh korakov:
- **Baza indukcije:** Preverimo in dokažemo, da trditev velja za začetno vrednost $n = n_0$.
- **Indukcijski korak:** Predpostavimo, da trditev velja za poljubno fiksno število $k \ge n_0$ (indukcijska hipoteza), in na podlagi tega dokažemo, da trditev nujno velja tudi za naslednje število $k+1$.

---

**42. Kaj je konceptualni razred?**

Konceptualni razred je eksplicitno podana množica, ki jo definiramo z vnaprej znano skupno lastnostjo $Q$. Vsebuje natanko tiste elemente iz univerzalne množice, ki izpolnjujejo to lastnost: $\mathcal{K} = \{ x \mid Q(x) \}$.

---

**43. Kdaj je teorija (razred izrekov) dvoumna?**

Razred izrekov je dvoumen, kadar znotraj teorije obstaja vsaj en izrek (ali element), do katerega lahko pridemo z uporabo pravil izpeljave na več kot en strukturno različen način (obstajata vsaj dve različni konstrukcijski drevesi oziroma zaporedji pravil za isti izrek). Če je pot do vsakega izreka enolična, je razred nedvoumen.

## 3. SKLOP: Kombinatorika in preštevanje

**6. Binomski izrek in njegov dokaz!**

**Izrek:** Za poljubni realni števili $a, b$ in naravno število $n$ velja:

$$(a+b)^n = \sum_{k=0}^{n} \binom{n}{k} a^{n-k} b^k$$

**Dokaz:** Izraz $(a+b)^n$ zapišemo kot produkt $n$ enakih oklepajev: $(a+b)(a+b)\dots(a+b)$. Ko te oklepaje zmnožimo, iz vsakega posameznega oklepaja izberemo bodisi člen $a$ bodisi člen $b$. Splošni člen, ki nastane z množenjem, bo oblike $a^{n-k}b^k$. To pomeni, da smo izmed $n$ razpoložljivih oklepajev v natanko $k$ oklepajih izbrali člen $b$, v preostalih $(n-k)$ pa člen $a$. Število načinov, kako lahko izmed $n$ oklepajev izberemo $k$ tistih, iz katerih bomo vzeli $b$, je natanko enako številu neurejenih izbir brez ponavljanja, kar znaša $\binom{n}{k}$. Zato je to ravno koeficient pred členom $a^{n-k}b^k$.

---

**7. Princip golobnjaka in Dirichletov princip**

- **Princip golobnjaka (osnovni):** Če razporedimo $n$ predmetov (golobov) v $m$ predalov (lukenj) in velja $n > m$, potem bo vsaj v enem predalu pristal več kot en predmet (vsaj 2 goloba).
- **Dirichletov princip (splošni):** Če se $n$ golobov namesti v $m$ golobjih lukenj za $n, m \in \mathbb{N}$, potem je v vsaj eni golobnji luknji nameščenih vsaj $\lceil \frac{n}{m} \rceil$ golobov.

---

**21. Kaj so neurejene izbire s ponavljanjem, kaj je $C_p(n,k)$ in kako izrazimo $C_p(n,k)$?**

Neurejena izbira s ponavljanjem je poljubna izbira $k$ elementov izmed $n$ različnih ponujenih elementov, pri čemer vrstni red izbiranja ni pomemben, posamezen element pa lahko izberemo večkrat (posamezen element se v množici lahko ponovi do $k$-krat).

Število vseh takšnih izbir označimo s $C_p(n,k)$ in ga izračunamo kot:

$$C_p(n, k) = \binom{n+k-1}{k} = \frac{(n+k-1)!}{k!(n-1)!}$$

---

**22. Obrazložite kaj je to urejena izbira $k$ elementov med $n$ elementi, $k \le n$, in kaj je $P(n, k)$?**

Pri urejeni izbiri izmed $n$ različnih elementov izberemo $k$ elementov ($k \le n$), pri čemer nam je vrstni red izbire pomemben (določimo zaporedne pozicije $n_1, n_2, \dots, n_k$). Ker elementov ne vračamo, se ne morejo ponavljati.

Število vseh takih izbir označimo s $P(n,k)$ (tudi variacije brez ponavljanja). Izračunamo ga kot:

$$P(n, k) = \frac{n!}{(n-k)!} = n \cdot (n-1) \cdot \dots \cdot (n-k+1)$$

Ko je $k=n$, urejamo vse elemente, kar imenujemo permutacije, $P(n,n) = n!$.

---

**32. Podane so množice $A_1, A_2$ in $A_3$. Zapišite število elementov v $A_1 \cup A_2 \cup A_3$!**

Uporabimo formulo vključitev-izključitev za tri množice:

$$|A_1 \cup A_2 \cup A_3| = |A_1| + |A_2| + |A_3| - |A_1 \cap A_2| - |A_1 \cap A_3| - |A_2 \cap A_3| + |A_1 \cap A_2 \cap A_3|$$

---

**44. & 45. Napiši pravilo za seštevanje in množenje!**

- **Pravilo seštevanja:** Če lahko nek dogodek izberemo na $A$ načinov, drugi neodvisen dogodek pa na $B$ načinov (pri čemer se možnosti ne prekrivajo), potem lahko izberemo prvi ali drugi dogodek na $A + B$ načinov.
- **Pravilo množenja:** Če je postopek sestavljen iz dveh zaporednih korakov, kjer lahko prvi korak naredimo na $A$ načinov, drugega pa neodvisno od prvega na $B$ načinov, potem lahko celoten postopek izvedemo na $A \cdot B$ načinov.

---

**46. & 47. Kaj je neurejena / urejena izbira?**

- **Neurejena izbira (kombinacija):** Izbira $k$ elementov izmed $n$ elementov, kjer vrstni red izbiranja ne vpliva na rezultat (izid je zgolj podmnožica).
- **Urejena izbira (variacija/permutacija):** Izbira $k$ elementov izmed $n$ elementov, kjer je končni vrstni red izbranih elementov ključen (izid je urejena $k$-terica).

---

**52. Kakšna je povezava med številom različnih urejenih $(n, k)$ izbir in številom neurejenih $(n, k)$ izbir?**

Iz vsake posamezne neurejene izbire $k$ elementov lahko dobimo urejene izbire tako, da teh $k$ izbranih elementov naknadno poljubno razporedimo po vrstnem redu. Ker lahko $k$ elementov med seboj uredimo na $P(k,k) = k!$ načinov, po pravilu množenja velja:

$$P(n, k) = C(n, k) \cdot k! \quad \Rightarrow \quad C(n, k) = \frac{P(n, k)}{k!}$$

## 4. SKLOP: Rekurzivne relacije

**23. Zapišite splošno homogeno linearno rekurzivno relacijo s konstantnimi koeficienti in pojasnite kako jo rešimo?**

**Zapis:** Splošna oblika reda $k$ je:

$$c_n a_n + c_{n-1} a_{n-1} + c_{n-2} a_{n-2} + \dots + c_{n-k} a_{n-k} = 0$$

kjer so $c_i \in \mathbb{R}$ konstantni koeficienti in $c_n, c_{n-k} \neq 0$.

**Postopek reševanja:**
1. Nastavimo in zapišemo karakteristični polinom z zamenjavo $a_{n-i} \to r^{k-i}$:
   $$c_n r^k + c_{n-1} r^{k-1} + \dots + c_{n-k} = 0$$
2. Poiščemo vse ničle karakterističnega polinoma ($r_1, r_2, \dots$).
3. Glede na kratnost in naravo ničel (realne ali kompleksne) sestavimo splošni nastavek za $a_n$. Za enostavno realno ničlo $r$ dodamo člen $K \cdot r^n$, za ničlo kratnosti $m$ pa dodamo $(K_0 + K_1 n + \dots + K_{m-1} n^{m-1}) r^n$.

---

**33. Zapišite nastavek za partikularno rešitev rekurzije $a_n - 5a_{n-1} + 6a_{n-2} = 6n2^n$.**

Karakteristični polinom homogenega dela je $r^2 - 5r + 6 = (r-2)(r-3) = 0$, kar daje homogeni ničli $r_1=2$ in $r_2=3$.

Desna stran ima eksponentno bazo $\alpha = 2$, ki je enokratna ničla homogenega dela (kratnost $s=1$). Polinom ob njej ($6n$) je stopnje $m=1$.

Splošni nastavek za partikularno rešitev $a_n^{(p)}$ je zato:

$$a_n^{(p)} = n^s \cdot (An + B) \cdot \alpha^n = n(An + B)2^n = (An^2 + Bn)2^n$$

---

**34. Karakteristični polinom homogene linearne rekurzivne relacije ima ničle $r_1 = r_2 = 3, r_3 = -1 - i$ in $r_4 = -1 + i$. Zapišite splošno rešitev.**

Ničla $3$ je dvokratna realna: pripada ji del $(A + Bn)3^n$.

Kompleksni par $r_{3,4} = -1 \pm i$ pretvorimo v polarno obliko:
- Radij $r = \sqrt{(-1)^2 + 1^2} = \sqrt{2}$.
- Kot $\phi = \arctan\left(\frac{1}{-1}\right) = \frac{3\pi}{4}$ (v II. kvadrantu).

Pripada jima del: $(\sqrt{2})^n \left(C \cos\frac{3\pi n}{4} + D \sin\frac{3\pi n}{4}\right)$.

Splošna rešitev:

$$a_n = (A + Bn)3^n + (\sqrt{2})^n \left(C \cos\frac{3\pi n}{4} + D \sin\frac{3\pi n}{4}\right)$$

---

**35. Nastavek za partikularni del nehomogene rekurzije ($f(n)$ primer s kosinusom)**

Če imamo nehomogeni del oblike $f(n) = P_m(n) \cdot \alpha^n \cos(\phi n)$, se nastavek oblikuje z uporabo splošnih polinomov stopnje $m$ tako za kosinusni kot sinusni del, pomnoženo z $n^s$, kjer je $s$ kratnost kompleksnega števila $\alpha(\cos \phi + i\sin \phi)$ kot ničle homogenega dela:

$$a_n^{(p)} = n^s \alpha^n \left( Q_m(n) \cos(\phi n) + R_m(n) \sin(\phi n) \right)$$

## 5. SKLOP: Asimptotična zahtevnost algoritmov

**24. Kaj pomeni zapis $f(n) = O(g(n))$?**

Zapis pomeni, da je funkcija $f(n)$ asimptotično omejena navzgor s funkcijo $g(n)$ (veliki O). Formalno: obstajata pozitivna realna konstanta $C > 0$ in naravno število $n_0 \in \mathbb{N}$, da velja:

$$|f(n)| \le C \cdot |g(n)| \quad \forall n \ge n_0$$

V tem primeru rečemo, da je $g(n)$ asimptotična zgornja meja funkcije $f(n)$.

## 6. SKLOP: Teorija števil in kongruence

**8. Kaj je relacija deljivosti nad $\mathbb{Z}$?**

Relacija deljivosti nad celimi števili $\mathbb{Z}$ (oznaka $a \mid b$, beremo "$a$ deli $b$") velja natanko tedaj, ko obstaja tako celo število $k \in \mathbb{Z}$, da lahko število $b$ zapišemo kot produkt:

$$b = k \cdot a$$

---

**9. Kaj je izrek o deljenju?**

Osnovni izrek o deljenju z ostankom: Za poljubni celi števili $a, b \in \mathbb{Z}$, kjer je $b \neq 0$, obstajata enolično določeni celi števili $q$ (količnik) in $r$ (ostanek), da velja:

$$a = q \cdot b + r \quad \text{in} \quad 0 \le r < |b|$$

---

**10. Kaj je Evklidov algoritem in kaj je njegov obrat?**

Evklidov algoritem je sistematičen postopek za iskanje največjega skupnega delitelja dveh celih števil $D(a, b)$. Deluje na zaporedni uporabi izreka o deljenju z ostankom: v vsakem koraku delimo prejšnji delitelj s prejšnjim ostankom. Postopek ustavimo, ko dobimo ostanek $0$. Največji skupni delitelj je zadnji neničelni ostanek.

Obrat Evklidovega algoritma (Bézoutova identiteta) nam omogoča, da izračunani $D(a,b) = d$ zapišemo kot linearno kombinacijo prvotnih števil $a$ in $b$ z uporabo celih števil $x, y \in \mathbb{Z}$:

$$ax + by = D(a, b)$$

Dobimo ga z izražanjem ostankov od spodaj navzgor skozi korake Evklidovega algoritma.

---

**11. Kakšen sistem enačb kongruence lahko rešimo s kitajskim izrekom?**

S Kitajskim izrekom o ostankih lahko rešimo sistem linearnih kongruenčnih enačb oblike $x \equiv c_i \pmod{n_i}$ za $i = 1, \dots, k$, pod pogojem, da so vsi moduli paroma tuji, torej velja $D(n_i, n_j) = 1$ za vsak par $i \neq j$. Rešitev takšnega sistema je enolično določena znotraj modula $M = n_1 \cdot n_2 \cdot \dots \cdot n_k$.

---

**31. Kdaj obstaja rešitev kongruence $ax \equiv b \pmod n$?**

Linearna kongruenca ima rešitev natanko tedaj, ko največji skupni delitelj koeficienta $a$ in modula $n$ deli desno stran $b$:

$$D(a, n) \mid b$$

Če je ta pogoj izpolnjen, ima kongruenca natanko $D(a,n)$ različnih rešitev znotraj modula $n$.

---

**53. Kako rešimo linearno kongruenco $ax \equiv b \pmod n$?**

1. Izračunamo $d = D(a, n)$ s pomočjo Evklidovega algoritma in preverimo, ali $d \mid b$. Če ne deli, rešitev ne obstaja.
2. Če $d \mid b$ in je $d > 1$, celotno kongruenco (torej $a, b$ in $n$) delimo z $d$, s čimer jo prevedemo na ekvivalentno kongruenco $a'x \equiv b' \pmod{n'}$, kjer sta $D(a', n') = 1$.
3. Z obratom Evklidovega algoritma poiščemo modularni inverz elementa $a'$ (to je število $x'$ za katero velja $a'x' \equiv 1 \pmod{n'}$).
4. Kongruenco pomnožimo z inverzom, da pred $x$ ostane koeficient $1$, s čimer osamimo rešitev $x \equiv b' \cdot x' \pmod{n'}$.

## 7. SKLOP: Relacije in delne urejenosti

**12. Opišite kako predstavimo relacijo z matriko in kako z digrafom?**

Naj bo $R \subseteq A \times B$ relacija:

- **Predstavitev z matriko (logična matrika):** Ustvarimo matriko dimenzije $|A| \times |B|$, kjer vrstice predstavljajo elemente množice $A$, stolpci pa elemente množice $B$. Element matrike na mestu $(i, j)$ je enak $1$, če sta elementa v relaciji ($a_i R b_j$), in $0$, če nista ($a_i \cancel{R} b_j$).
- **Predstavitev z digrafom (usmerjenim grafom):** Elemente množic narišemo kot točke (vozlišča) v ravnini. Če velja $a R b$, narišemo usmerjeno povezavo (puščico), ki poteka od točke $a$ proti točki $b$.

---

**13. Kaj je tranzitivna ovojnica in napiši algoritem za njo.**

Tranzitivna ovojnica relacije $R$ (oznaka $R^t$) je najmanjša tranzitivna relacija nad množico $A$, ki vsebuje prvotno relacijo $R$. Dobimo jo tako, da relaciji dodamo najmanjše možno število parov $(a, c)$, ki manjkajo, da bi zadostili pogoju tranzitivnosti (če velja $aRb$ in $bRc$, dodamo $aRc$).

**Algoritem (Floyd-Warshallov / Warshallov algoritem):** Deluje nad matrično predstavitvijo relacije $W$:

```
Za k = 1 do n
    Za i = 1 do n
        Za j = 1 do n
            W[i,j] := W[i,j] ali (W[i,k] in W[k,j])
```

---

**25. Pojasnite kdaj relacija delno ureja množico (lastnosti s simboli) in zapišite tri lastnosti delno urejenih množic.**

Relacija $R$ nad množico $A$ delno ureja množico $A$, če ima naslednje tri lastnosti:
- Refleksivnost: $\forall x \in A : xRx$
- Antisimetričnost: $\forall x, y \in A : (xRy \wedge yRx) \Rightarrow x = y$
- Tranzitivnost: $\forall x, y, z \in A : (xRy \wedge yRz) \Rightarrow xRz$

Tri lastnosti / posebnosti delno urejenih množic:
- Vsebujejo lahko neprimerljive elemente (ni nujno, da za poljubna $x, y$ velja $xRy$ ali $yRx$).
- Lahko jih nazorno vizualiziramo s Hassejevimi diagrami.
- Množica ima lahko več maksimalnih ali minimalnih elementov hkrati.

---

**40. Kdaj je relacija ekvivalenčna, ekvivalenčni razred in razbitje množic?**

- Relacija je ekvivalenčna, če je refleksivna, simetrična ($\forall x,y: xRy \Rightarrow yRx$) in tranzitivna.
- Ekvivalenčni razred elementa $x$ (oznaka $[x]_R$) je množica vseh elementov iz $A$, ki so v ekvivalenčni relaciji z $x$: $[x]_R = \{ y \in A \mid xRy \}$.
- Razbitje (particija) množice $A$ je družina nepraznih, paroma disjunktnih podmnožic $A_1, A_2, \dots, A_k$, katerih unija tvori celotno množico $A$. Izrek: Ekvivalenčni razredi poljubne ekvivalenčne relacije vedno tvorijo razbitje izvorne množice.

---

**54. Naštej 5 lastnosti relacij!**

Za relacijo $R \subseteq A \times A$:
- Refleksivnost: $\forall x \in A : xRx$
- Simetričnost: $\forall x, y \in A : xRy \Rightarrow yRx$
- Antisimetričnost: $\forall x, y \in A : (xRy \wedge yRx) \Rightarrow x = y$
- Tranzitivnost: $\forall x, y, z \in A : (xRy \wedge yRz) \Rightarrow xRz$
- Sovisnost: $\forall x, y \in A : x \neq y \Rightarrow (xRy \vee yRx)$

---

**55. Kaj so posebni elementi neke urejenosti?**

Naj bo $(A, R)$ delno urejena množica in $x \in A$:
- **Minimalni element:** Če v $A$ ne obstaja noben element $y \neq x$, za katerega bi veljalo $yRx$.
- **Maksimalni element:** Če v $A$ ne obstaja noben element $y \neq x$, za katerega bi veljalo $xRy$.
- **Prvi (najmanjši) element:** Če za vsak element $y \in A$ velja $xRy$ (če obstaja, je enoličen).
- **Zadnji (največji) element:** Če za vsak element $y \in A$ velja $yRx$ (če obstaja, je enoličen).

## 8. SKLOP: Mreže in Boolove algebre

**14. Kdaj je mreža omejena?**

Mreža je omejena, če ima kot delno urejena množica hkrati prvi element (ki ga označujemo z $0$, predstavlja absolutno spodnjo mejo celotne strukture) in zadnji element (ki ga označujemo z $1$, predstavlja absolutno zgornjo mejo strukture).

---

**26. Kdaj je mreža distributivna?**

Mreža je distributivna, če v njej velja distributivnostni zakon operacij sup ($\vee$) in inf ($\wedge$) za poljubne tri elemente $a, b, c$:

$$a \wedge (b \vee c) = (a \wedge b) \vee (a \wedge c)$$

(Ali ekvivalentno: $a \vee (b \wedge c) = (a \vee b) \wedge (a \vee c)$).

---

**27. Kaj je algebrska mreža (Zapiši katerokoli definicijo mreže)?**

- **Relacijska definicija:** Delno urejena množica $(M, \le)$ je mreža, če za vsak par elementov $a, b \in M$ obstajata njun natančni zgornji rob ($\sup\{a, b\}$) in natančni spodnji rob ($\inf\{a, b\}$).
- **Algebrska definicija:** Mreža je algebrska struktura $(M, \wedge, \vee)$ z dvema binarnima operacijama, ki za vse elemente izpolnjujeta štiri osnovne zakone: komutativnost, asociativnost, idempotentnost in absorbcijo.

---

**48. Kaj je definicija relacijske booleove algebre?**

Relacijska Booleova algebra je omejena, distributivna in komplementirana mreža. To pomeni, da poleg distributivnosti v njej obstajata elementa $0$ in $1$, ter za vsak element $a$ obstaja njemu pripadajoči komplement $a'$, da velja $a \vee a' = 1$ in $a \wedge a' = 0$.

## 9. SKLOP: Teorija grafov

**15. Definicija Eulerjevega grafa?**

Graf $G$ je Eulerjev, če vsebuje Eulerjev obhod (včasih imenovan cikel). To je sklenjen sprehod, ki prepotuje vsako povezavo grafa $G$ natanko enkrat ter se zaključi v istem vozlišču, kjer se je začel.

---

**16. Kateri pogoj je ekvivalenčen, da je graf Eulerjev?**

Izrek pravi: Graf $G$ brez izoliranih vozlišč je Eulerjev natanko tedaj, ko je povezan in so vsa njegova vozlišča sode stopnje (stopnja vsakega vozlišča je deljiva z 2).

---

**17. Kako poiščemo Eulerjev obhod?**

Poiščemo ga s Fleuryjevim algoritmom:
1. Začnemo v poljubnem vozlišču grafa.
2. V vsakem koraku izberemo naslednjo poljubno sosednjo povezavo in jo prehodimo, nakar jo iz grafa izbrišemo.
3. Ključno pravilo: Povezavo, ki predstavlja most (povezavo, katere izbris bi razvezal graf na več komponent), izberemo le v primeru, ko nimamo na voljo nobene druge preostale povezave.
4. Postopek ponavljamo, dokler ne porabimo vseh povezav.

---

**18. Kdaj je graf ravninski in kaj pravi izrek Kuratowskega?**

Graf je ravninski, če ga je mogoče vložiti v ravnino – to pomeni, da ga lahko narišemo na ravnino tako, da se nobene dve povezavi ne sekata zunaj svojih krajišč (vozlišč).

**Izrek Kuratowskega:** Graf je ravninski natanko tedaj, ko ne vsebuje podgrafa, ki je izomorfen subdiviziji polnega grafa $K_5$ ali polnega dvodelnega grafa $K_{3,3}$.

---

**28. Nariši grafe $P_6, C_7, K_5, K_{2,3}$**

- $P_6$ (pot na 6 vozliščih): 6 točk, povezanih zaporedno v eno linijo: $v_1 - v_2 - v_3 - v_4 - v_5 - v_6$.
- $C_7$ (cikel na 7 vozliščih): 7 točk, sklenjenih v krog (sedemkotnik).
- $K_5$ (polni graf na 5 vozliščih): 5 točk (zvezda v petkotniku), kjer je vsaka točka povezana z vsemi ostalimi 4 točkami (vsa vozlišča imajo stopnjo 4).
- $K_{2,3}$ (polni dvodelen graf): Vozlišča razdelimo v dve skupini: v prvi sta 2 točki, v drugi 3 točke. Vsaka točka iz prve skupine je povezana z vsemi tremi točkami iz druge skupine (povezav med točkami znotraj iste skupine ni).

---

**36. Katero zaporedje ni zaporedje stopenj vozlišč?**

Zaporedje stopenj vozlišč ne more obstajati, če krši Lemo o rokovanju (vsota vseh stopenj mora biti enaka dvakratnemu številu povezav, torej mora biti sodo število). Iz tega sledi zlato pravilo: vsako zaporedje stopenj mora vsebovati SODO ŠTEVILO LIHIH ELEMENTOV.

Primer $(5,4,3,3,3,2,1)$ vsebuje liha števila: 5, 3, 3, 3, 1 (skupaj 5 lihih elementov). Ker je 5 liho število, takšen graf ne more obstajati.

---

**49. Kaj je lema o rokovanju?**

Lema o rokovanju (Handshaking lemma): V vsakem grafu $G = (V, E)$ je vsota stopenj vseh vozlišč enaka dvakratnemu številu njegovih povezav:

$$\sum_{v \in V} \deg(v) = 2 \cdot |E|$$

---

**50. Kako se imenuje graf, kateri ima vsa vozlišča stopnje $r$?**

Tak graf se imenuje $r$-regularen graf.

---

**51. Kdaj sta grafa $G$ in $H$ izomorfna in kako pokažemo, da nista?**

Grafa $G$ in $H$ sta izomorfna ($G \cong H$), če obstaja bijekcija $\phi: V(G) \to V(H)$ med njunima množicama vozlišč, ki ohranja strukturo povezav. To pomeni, da sta vozlišči $u$ in $v$ sosednji v grafu $G$ natanko tedaj, ko sta $\phi(u)$ in $\phi(v)$ sosednji v grafu $H$.

**Kako pokažemo, da nista izomorfna:** Poiščemo poljubno strukturno lastnost (invariant), ki se med grafoma razlikuje. Če imata grafa npr. različno število vozlišč, različno število povezav, različna zaporedja stopenj vozlišč ali pa eden vsebuje trikotnik ($C_3$), drugi pa ne, grafa dokazano nista izomorfna.

---

**56. Kaj je Hamiltonov graf, Hamiltonov cikel, Diracov izrek in Orejev izrek?**

Graf je Hamiltonov, če vsebuje Hamiltonov cikel – to je vpet cikel, ki obišče vsako vozlišče grafa natanko enkrat in se vrne v izhodišče.

- **Diracov izrek:** Če je $G$ enostaven graf z $n \ge 3$ vozlišči in ima vsako vozlišče stopnjo vsaj $\frac{n}{2}$ ($\forall v \in V: \deg(v) \ge \frac{n}{2}$), potem je graf $G$ Hamiltonov.
- **Orejev izrek:** Če je $G$ enostaven graf z $n \ge 3$ vozlišči in za vsak par nesosednjih vozlišč $u, v$ velja, da je vsota njunih stopenj vsaj $n$ ($\deg(u) + \deg(v) \ge n$), potem je graf $G$ Hamiltonov.

---

**57. Kaj so Peanovi aksiomi?**

Peanovi aksiomi so množica petih logičnih aksiomov, ki eksplicitno definirajo strukturo naravnih števil $\mathbb{N}$ z uporabo operacije naslednika ($n^+$):

1. $1$ je naravno število ($1 \in \mathbb{N}$).
2. Vsakemu naravnemu številu $n$ pripada enoličen naslednik $n^+ \in \mathbb{N}$.
3. Število $1$ ni naslednik nobenega naravnega števila ($\forall n: n^+ \neq 1$).
4. Če sta naslednika enaka, sta enaki tudi števili ($a^+ = b^+ \Rightarrow a = b$).
5. (Aksiom indukcije): Če za podmnožico $K \subseteq \mathbb{N}$ velja, da je $1 \in K$ in da iz $k \in K$ sledi $k^+ \in K$, potem je $K = \mathbb{N}$.

---

**58. Kaj je hiperkocka?**

Hiperkocka $Q_n$ ($n$-dimenzionalna kocka) je regularen graf z $2^n$ vozlišči, kjer vsako vozlišče predstavimo z binarnim nizom dolžine $n$. Dve vozlišči sta povezani s povezavo natanko tedaj, ko se njuna binarna zapisa razlikujeta na natanko enem mestu.

---

**59. Kaj je drevo?**

Drevo je povezan graf, ki ne vsebuje nobenega cikla.

---

**60. Kaj je triangulirani ravninski graf ali triangulacije?**

To je maksimalni ravninski graf, ki mu ni mogoče dodati nobene nove povezave, ne da bi s tem porušili lastnost ravninskosti. V takšnem grafu je vsako lice (vključno z zunanjim) omejeno s ciklom dolžine 3 (trikotnikom). Za tak graf velja ekstremna meja števila povezav: $|E| = 3|V| - 6$.

---

**61. Eulerjeva formula!**

Za vsak povezan ravninski graf velja invariantno razmerje med številom vozlišč ($v$), številom povezav ($p$) in številom lic ($l$, vključno z zunanjim):

$$v - p + l = 2$$

---

**62. Kdaj je graf dvodelen?**

Graf je dvodelen (bipartiten), če lahko njegovo množico vozlišč razdelimo na dve disjunktni skupini $V_1$ in $V_2$ ($V = V_1 \cup V_2$), tako da vsaka povezava v grafu povezuje izključno eno vozlišče iz $V_1$ z enim vozliščem iz $V_2$. Izrek: Graf je dvodelen natanko tedaj, ko ne vsebuje nobenega lihega cikla ($C_3, C_5, \dots$).

---

**63. Kaj je podgraf, vpet podgraf in induciran podgraf?**

Naj bo $G = (V, E)$ krovni graf:

- **Podgraf $H$:** Graf, katerega vozlišča in povezave so podmnožice izvornega grafa ($V(H) \subseteq V(G)$ in $E(H) \subseteq E(G)$).
- **Vpet podgraf (Spanning subgraph):** Podgraf, ki vsebuje vsa vozlišča prvotnega grafa ($V(H) = V(G)$), izberemo pa le poljubno podmnožico povezav.
- **Induciran podgraf:** Podgraf, ki ga določimo z izbiro podmnožice vozlišč $V' \subseteq V$, pri čemer moramo obvezno vzeti vse tiste povezave iz $G$, ki imata obe krajišči v tej izbrani podmnožici $V'$.
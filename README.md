# Techno Cats - Zork

## Úvod

Ahoj, tohle je zadání pro tvůj první individuální projekt v Javě.

Vytvoříme si společně dobrodružnou hru na bázi textových příkazů v konzoli.

Ve své hře budeš mít možnost prozkoumávat různé místnosti, bojovat s nepřáteli, sbírat předměty, používat zbraně a nakonec i porazit finálního bosse.

---

# Ukládání práce

Vytvoř si v tomto repozitáři svou vlastní branch s názvem `dev/github_jmeno` _(např. dev/robacz)_ a veškerou svou práci do ní pushuj.

---

# Úkoly

Poprosil bych tě jenom, ať nejdříve splníš tyto úkoly a teprve potom dáváš větší prostor své fantazii.

## 1. Příběh

Nejdříve si vytvoř (případně sepiš) jednoduchý scénář (příběh), který bude tvou hru tvořit.

Vytvoř scénář, popisující, co všechno může hráče v průběhu hry potkat.

> [!TIP]
> Nezapomeň na různé podrobnosti, tvé fantazii se meze nekladou.

## 2. Seznámení s projektem a základní úpravy

Důkladně si projdi celý dosavadní kód projektu a snaž se všemu porozumět.

V zadaném kódu se mohou nacházet chyby, které bude třeba opravit.

Přepracuj třídu `CommandLineUI` na **Singleton**.

> [!NOTE]
> **Singleton** je návrhový vzor, zajišťující, že třída má pouze jednu instanci a poskytuje k ní statický přístup.

Zajisti, aby hra nepadala při nesprávném zadání vstupu od uživatele _(např. zadání neexistujícího příkazu)_ a vypisuj chybové hlášky.

## 3. Základ implementace příkazů

K zapouzřování logiky nad příkazy používáme interface `Command`.

> [!CAUTION]
> Je důležité ve třídách příkazů nedržet žádná měněná data pro zachování obnovitelnosti. (Abychom nemuseli reinicializovat po použití.)

Implementuj příkaz `jdi`, umožňující hráči procházet místnostmi pomocí jejich východů. Každá místnost by měla mít nějaké východy _(sever, jih, západ, východ)_.

## 4. Naším nepřítelem není kód

Vytvoř třídu pro nepřátele `Enemy` s použitím kombinace Flyweight a Builder, obsahující základní statistiky jako jeho životy, rozsah poškození (při útoku se náhodně vybere z rozsahu), případně další specifikace. Nepřítel bude generovat nějaké poškození a může mu být uděleno poškození.

> [!NOTE]
> **Flyweight** je návrhový vzor, který šetří operační paměť pomocí rozdělení třídy na společnou část (sdílenou mezi ostaními objekty) a vlastní část (uchovávanou unikátně uvnitř sebe).

> [!NOTE]
> **Builder** je návrhový vzor, který usnadňuje vytváření složitých objektů postupným skládáním jejich částí.

## 5. Zaútočte!

Teď přijdou na řadu zbraně. Implementuj třídu pro zbraň (třeba `Weapon`), která bude obsahovat rozsah poškození.

Implemenuj příkaz `nasaď`, umožňující hráči sebrat zbraň z místnosti (případná původní zbraň se upustí zpět do místnosti).

Implemenuj příkaz `útok`, který při použití na neprátele způsobí náhodné poškození v rozsahu (v závislosti na zbrani). Pokud hráč neútočí na nepřítele nebo ho nezabije prvním útokem, nepřítel bude útočit na hráče.

## 6. Konec hry

Každá hra musí mít samozřejmě i svůj konec, takže ho společně přidáme.

Implementuj příkazy `restart` (pro obnovení hry do původního stavu na začátku) a `konec` (pro ukončení hry).

Implementuj finálního bosse (speciálního nepřítele `Enemy`), který bude ve speciální uzamčené místnosti.

> [!CAUTION]
> Hráč musí nejdříve získat klíč pro vstup do speciální místnosti s finálním bosem.

Klíč bude součástí inventáře, který bude mít fixně omezenou kapacitu. Implemenuj ho a přidej příkazy jako `seber` a `polož` pro jeho správu. Samozřejmě nezapomeň vymyslet způsob, kterým hráč obdrží nebo najde ten klíč :)

## 7. Změny v inventáři

Vytvoř implementaci **observer** patternu pro inventář hráče (se bude chovat jako Publisher). Každý přidaný nebo odebraný předmět z inventáře by měl informovat všechny Listenery o změně.

> [!NOTE]
> **Observer** je návrhový vzor, který zajišťuje automatickou aktualizaci pozorovatelů (Listener) při změně stavu pozorovaného objektu (Publisher).

Implementujte listener pro vypisování informací hráči o přidaných a odebraných předmětech z inventáře (např. když hráč sebere klíč).

## 8. Rozšíření naší hry

Můžeš přidat také další předměty, které může hráč sbírat a případně používat.

Přidat můžeš například:
- **Štít** pro blokování útoků.
- **Lektvary** pro zlepšení zdraví nebo jiné efekty.
- **Magické předměty** s různými efekty (teleportace, apod.).

Tvá fantazie zde nemá žádné hranice!

## 9. Logování

Použij _(již přidanou)_ knihovnu **Log4j** pro logování a zapisuj všechny použité příkazy s jejich časem použití do souboru `prikazy.log`.

> [!IMPORTANT]
> Zajisti (pomocí logovací knihovny), aby se vývojářské informace neukazovali při hraní hráčům v konzoli.

---

# Doporučení

- Snaž se udržovat kód čistý a dobře strukturovaný. Velmi rychle se v něm dokáže vytvořit nepořádek.
- Testuj jednotlivé části hry v průběhu, aby ti bylo jasné, že všechno funguje správně.
- Nezapomeň na **QoL (Quality of Life)** změny, aby se hráči dobře hrálo a byl dostatečně informovaný o průběhu a změnách ve hře a jeho možnostech.

Přeji ti hodně zábavy při programování! Pokud budeš potřebovat pomoc, klidně se hned ozvi.
# Com crear un repositori de Git i fer un commit

Git serveix per guardar l'historial dels canvis d'un projecte. Un **repositori** és la carpeta del projecte controlada per Git, i un **commit** és una fotografia dels canvis en un moment concret.

## 1. Crear el repositori

Obre un terminal i entra a la carpeta del projecte:

```bash
cd /ruta/al/meu-projecte
```

Inicialitza-hi Git:

```bash
git init
```

Ara la carpeta és un repositori local. Pots comprovar-ho amb:

```bash
git status
```

## 2. Preparar els fitxers

Per afegir tots els fitxers al proper commit:

```bash
git add .
```

També pots afegir només un fitxer concret:

```bash
git add nom-del-fitxer.kt
```

Torna a consultar l'estat per veure què has preparat:

```bash
git status
```

Els fitxers preparats solen aparèixer en verd.

## 3. Fer el commit

Un commit ha de tenir un missatge breu que expliqui el canvi:

```bash
git commit -m "Afegeix el primer programa"
```

Per veure l'historial:

```bash
git log --oneline
```

## 4. Flux de treball habitual

Cada vegada que facis canvis, repeteix aquest procés:

```bash
git status
git add .
git commit -m "Descriu el canvi"
```

Abans de fer `git add .`, revisa que no estiguis afegint contrasenyes, claus secretes o fitxers que no vols compartir.

## 5. Connectar el repositori amb GitHub (opcional)

Primer crea un repositori buit a GitHub. Després, des del terminal, associa'l al repositori local:

```bash
git remote add origin https://github.com/usuari/meu-projecte.git
```

Canvia el nom de la branca principal a `main` i puja els commits:

```bash
git branch -M main
git push -u origin main
```

En els commits següents normalment només caldrà fer:

```bash
git push
```

## 6. Treballar amb branques

Una **branca** permet desenvolupar una funcionalitat o corregir un error sense modificar directament `main`. Quan el canvi està acabat, es pot integrar amb la branca principal.

Per veure les branques locals i saber en quina et trobes:

```bash
git branch
```

Crea una branca nova i canvia-t'hi:

```bash
git checkout -b afegeix-pantalla-inici
```

Per canviar a una branca que ja existeix:

```bash
git checkout main
```

En versions recents de Git també pots usar `git switch -c nom-branca` per crear-la i canviar-hi, o `git switch nom-branca` per canviar a una branca existent.

Fes els commits habituals a la branca nova. Quan vulguis incorporar-los a `main`, canvia a `main` i fusiona la branca:

```bash
git checkout main
git merge afegeix-pantalla-inici
```

Si la branca ja no fa falta després de fusionar-la, elimina-la:

```bash
git branch -d afegeix-pantalla-inici
```

Per pujar una branca a GitHub per primera vegada:

```bash
git push -u origin afegeix-pantalla-inici
```

Abans de fusionar, actualitza la branca principal amb els canvis remots:

```bash
git checkout main
git pull
```

## 7. Desfer canvis amb `reset`, `revert` i `restore`

Abans de desfer res, consulta l'estat i l'historial:

```bash
git status
git log --oneline
```

### `git reset`

`reset` mou el punt de la branca a un commit anterior. És útil per corregir commits locals que encara **no** has compartit amb altres persones.

Per desfer l'últim commit però conservar els canvis preparats per tornar a fer el commit:

```bash
git reset --soft HEAD~1
```

Per desfer l'últim commit i deixar els canvis al directori de treball, sense preparar-los:

```bash
git reset HEAD~1
```

Per descartar completament l'últim commit i tots els seus canvis:

```bash
git reset --hard HEAD~1
```

`git reset --hard` elimina canvis locals. No l'utilitzis si tens feina que vols conservar. Evita també reescriure amb `reset` commits que ja hagis pujat i que altres persones puguin estar utilitzant.

### `git revert`

`revert` crea un commit nou que desfà un commit anterior. És l'opció recomanada per desfer canvis que ja s'han compartit o que són a `main`.

```bash
git revert identificador-del-commit
```

Pots obtenir l'identificador amb `git log --oneline`. Git obrirà un missatge de commit; desa'l i tanca l'editor per confirmar el revertiment. Després, puja el commit nou:

```bash
git push
```

### Descartar un fitxer sense fer commit

Per recuperar la versió de l'últim commit d'un fitxer modificat:

```bash
git restore nom-del-fitxer.kt
```

Aquesta ordre descarta els canvis no confirmats d'aquell fitxer.

## 8. Reorganitzar commits amb `rebase`

`rebase` torna a aplicar els commits d'una branca sobre un altre punt de l'historial. Ajuda a mantenir una línia d'historial més clara, però pot canviar els identificadors dels commits.

Per actualitzar una branca de treball a partir de l'última versió de `main`:

```bash
git checkout afegeix-pantalla-inici
git fetch origin
git rebase origin/main
```

Si hi ha conflictes, Git indicarà els fitxers afectats. Resol-los, prepara els fitxers i continua:

```bash
git add nom-del-fitxer-en-conflicte.kt
git rebase --continue
```

Per cancel·lar el procés i tornar al punt anterior:

```bash
git rebase --abort
```

No facis `rebase` de commits compartits amb altres persones, perquè en canvia l'historial. Si ja havies pujat la teva branca i has fet `rebase`, cal actualitzar el remot amb precaució:

```bash
git push --force-with-lease
```

`--force-with-lease` és més segur que `--force`, ja que evita sobreescriure canvis remots que no tens localment.

## 9. Copiar un commit amb `cherry-pick`

`cherry-pick` aplica un commit concret d'una branca en una altra. Per exemple, és útil per portar una correcció urgent a `main` sense fusionar tota la branca de desenvolupament.

Primer canvia a la branca que ha de rebre el commit i consulta l'identificador del commit que vols copiar:

```bash
git checkout main
git log --oneline afegeix-pantalla-inici
```

Aplica'l amb:

```bash
git cherry-pick identificador-del-commit
```

Si apareix un conflicte, resol-lo, prepara els fitxers i continua:

```bash
git add nom-del-fitxer-en-conflicte.kt
git cherry-pick --continue
```

Per cancel·lar el `cherry-pick`:

```bash
git cherry-pick --abort
```

Finalment, revisa l'historial i puja el resultat si tot és correcte:

```bash
git log --oneline
git push
```
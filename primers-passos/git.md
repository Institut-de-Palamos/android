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
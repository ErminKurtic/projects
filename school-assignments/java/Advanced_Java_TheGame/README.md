<b>INSTRUKTIONER OCH TANKAR KRING PROJEKTET!</b>
- - - - - - - - - - - - - - - - - - - - -

Välkommen till "The Room Game"!
Nedanför kommer lite instruktioner på kommandon som man skriver för att kunna spela spelet.

- - - - -
<b>KOMMANDON:</b>
- - - - -

<b>1, 2, 3</b> och<b> 4:</b> - Talen används för att röra sig mellan rummen.

<b>pickup "itemnamn":</b> - Ordet "pickup" används när du vill plocka upp en grej som finns i rummet och lägga till det i din inventory. För att plocka upp en sak så skriver du pickup (mellanslag) och namnet på det du vill få med dig.

<b>exit:</b> - När du väl hittat nycklen och vill bege dig ut, så måste du vara på rätt plats med nyckeln i hand och skriva ordet "exit" för att kunna komma ut.


- - - - - - - - - - - - - - -
<b>KOMMENTARER KRING PROJEKTET:</b>
- - - - - - - - - - - - - - -

Dessvärre har jag inte hunnit med lika mycket som jag hoppats på. Ambitionen var hög men kunskapen var inte alls densamma och detta har visat sig vara en av de tuffaste uppgifterna jag tagit mig an.
I jämförelse med tidigare inlämningsuppgifter under kursen så har detta varit på en helt annan nivå. 
Inte bara med allmän kodkunskap från tidigare Java-kurs men även appliceringen av Streams som visat sig vara på en helt annat svårighetsgrad än vad tidigare uppgifter erbjöd.

I och med det så är jag inte helt nöjd med min insats, trots att jag försökt få med allt som krävs för att klara Godkänt. 
Dock har det medföljt en del buggar som kom upp och märktes av i sista stund innan deadline....

- - - - - - - - - - - -
<b>BUGGAR / SAKER ATT FIXA:</b>
- - - - - - - - - - - - 

<b>ROOM/INVENTORY:</b> - Spelet fungerade finfint genom hela processen gällande inventory och att kunna plocka upp saker och stoppa ner dom i inventoryt. 
Dock så bestämde sig koden i slutet att det tydligen inte gäller för alla rum, trots att de delar samma metoder/funktioner. 
Detta har medfört att items som plockas upp i ett eller flera rum inte följer med ner i inventory. Dock går det att plocka upp items i rummet där nyckeln finns för att kunda avsluta spelet.

<b>THREADS:</b> - Jag var dessvärre sjuksriven när vi gick igenom threads vilket resulterade till att jag kikade på det sista veckan och la till det i min slutfas på projektet.
Jag fick min s.k. Springpojke att springa runt på sin egen tråd i positionerna mellan rummen, men dessvärre lyckades jag inte lösa problemet att få honom att visa sig på ROOM-displayen.

<b>STREAMS:</b> - Efter vår inlämningsuppgift med Streams kändes det bra och jag tyckte jag hade stenkoll.
Dessvärre visade det sig vara mycket tuffare än förväntat i detta projekt och detta medförde att jag endast lyckades konvertera en array-funktion till en Stream efter mycket hjälp och stridande.

package com.example.retrofit2app

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SuperHeroProvider {

    companion object{
        private val json = """
        [{
          "superhero": "Yellow-brown sungazer",
          "publisher": "Talane",
          "realname": "Regan",
          "photo": "https://robohash.org/ipsasintconsequuntur.png?size=50x50&set=set1"
        }, {
          "superhero": "Eagle, bateleur",
          "publisher": "Bubblemix",
          "realname": "Ninette",
          "photo": "https://robohash.org/sintconsecteturofficiis.png?size=50x50&set=set1"
        }, {
          "superhero": "Brown brocket",
          "publisher": "BlogXS",
          "realname": "Pauletta",
          "photo": "https://robohash.org/repellendusnemout.png?size=50x50&set=set1"
        }, {
          "superhero": "Pocket gopher (unidentified)",
          "publisher": "Roombo",
          "realname": "Julietta",
          "photo": "https://robohash.org/porronobislaboriosam.png?size=50x50&set=set1"
        }, {
          "superhero": "Fox, silver-backed",
          "publisher": "Agivu",
          "realname": "Kaitlin",
          "photo": "https://robohash.org/quamoditlabore.png?size=50x50&set=set1"
        }, {
          "superhero": "Bustard, denham's",
          "publisher": "Shuffledrive",
          "realname": "Dyanne",
          "photo": "https://robohash.org/voluptatumrationenon.png?size=50x50&set=set1"
        }, {
          "superhero": "Dragon, ornate rock",
          "publisher": "Dablist",
          "realname": "Calhoun",
          "photo": "https://robohash.org/autemteneturdoloribus.png?size=50x50&set=set1"
        }, {
          "superhero": "Civet (unidentified)",
          "publisher": "Quire",
          "realname": "Leigha",
          "photo": "https://robohash.org/placeatrepellendusfacere.png?size=50x50&set=set1"
        }, {
          "superhero": "White-faced whistling duck",
          "publisher": "Abata",
          "realname": "Haven",
          "photo": "https://robohash.org/eoseosiure.png?size=50x50&set=set1"
        }, {
          "superhero": "Brown capuchin",
          "publisher": "Livetube",
          "realname": "Carmella",
          "photo": "https://robohash.org/voluptatumvoluptassimilique.png?size=50x50&set=set1"
        }, {
          "superhero": "Legaan, ground",
          "publisher": "Agivu",
          "realname": "Rudolfo",
          "photo": "https://robohash.org/quamteneturhic.png?size=50x50&set=set1"
        }, {
          "superhero": "Laughing kookaburra",
          "publisher": "Zoomcast",
          "realname": "Jonie",
          "photo": "https://robohash.org/idevenietullam.png?size=50x50&set=set1"
        }, {
          "superhero": "Dragonfly, russian",
          "publisher": "Gabtune",
          "realname": "Chrysa",
          "photo": "https://robohash.org/quomolestiasfacilis.png?size=50x50&set=set1"
        }, {
          "superhero": "Brocket, red",
          "publisher": "Demivee",
          "realname": "Currie",
          "photo": "https://robohash.org/doloresvoluptatemquod.png?size=50x50&set=set1"
        }, {
          "superhero": "American black bear",
          "publisher": "Skynoodle",
          "realname": "D'arcy",
          "photo": "https://robohash.org/consequunturnamquaerat.png?size=50x50&set=set1"
        }, {
          "superhero": "Common mynah",
          "publisher": "Vipe",
          "realname": "Shelbi",
          "photo": "https://robohash.org/temporibusvelitcorporis.png?size=50x50&set=set1"
        }, {
          "superhero": "Trotter, lily",
          "publisher": "Thoughtsphere",
          "realname": "Bernetta",
          "photo": "https://robohash.org/magninumquameligendi.png?size=50x50&set=set1"
        }, {
          "superhero": "Legaan, water",
          "publisher": "Jetwire",
          "realname": "Mona",
          "photo": "https://robohash.org/corporisidquibusdam.png?size=50x50&set=set1"
        }, {
          "superhero": "Common boubou shrike",
          "publisher": "Oyope",
          "realname": "Renie",
          "photo": "https://robohash.org/vitaevoluptatesveritatis.png?size=50x50&set=set1"
        }, {
          "superhero": "Otter, cape clawless",
          "publisher": "Devshare",
          "realname": "Emanuele",
          "photo": "https://robohash.org/dolordebitisquisquam.png?size=50x50&set=set1"
        }, {
          "superhero": "Dolphin, striped",
          "publisher": "Dabshots",
          "realname": "Uta",
          "photo": "https://robohash.org/mollitiarerumiste.png?size=50x50&set=set1"
        }, {
          "superhero": "Egret, snowy",
          "publisher": "Photobean",
          "realname": "Pinchas",
          "photo": "https://robohash.org/quialaborumomnis.png?size=50x50&set=set1"
        }, {
          "superhero": "Green-backed heron",
          "publisher": "Thoughtbeat",
          "realname": "Elroy",
          "photo": "https://robohash.org/nonvoluptatemearum.png?size=50x50&set=set1"
        }, {
          "superhero": "Jackal, silver-backed",
          "publisher": "Eayo",
          "realname": "Aaron",
          "photo": "https://robohash.org/harumquaerataperiam.png?size=50x50&set=set1"
        }, {
          "superhero": "Owl, burrowing",
          "publisher": "Blogtag",
          "realname": "Ermin",
          "photo": "https://robohash.org/omnisofficiissint.png?size=50x50&set=set1"
        }, {
          "superhero": "Steenbok",
          "publisher": "Voonder",
          "realname": "Moishe",
          "photo": "https://robohash.org/delectusomnisut.png?size=50x50&set=set1"
        }, {
          "superhero": "Southern screamer",
          "publisher": "Izio",
          "realname": "Rosabella",
          "photo": "https://robohash.org/placeatessenihil.png?size=50x50&set=set1"
        }, {
          "superhero": "Jaguarundi",
          "publisher": "Demimbu",
          "realname": "Marwin",
          "photo": "https://robohash.org/etsequisapiente.png?size=50x50&set=set1"
        }, {
          "superhero": "Common seal",
          "publisher": "Skiba",
          "realname": "Thatcher",
          "photo": "https://robohash.org/mollitiaevenietplaceat.png?size=50x50&set=set1"
        }, {
          "superhero": "Pig-tailed macaque",
          "publisher": "Skynoodle",
          "realname": "Wade",
          "photo": "https://robohash.org/modiidet.png?size=50x50&set=set1"
        }, {
          "superhero": "African lion",
          "publisher": "Chatterpoint",
          "realname": "Artemus",
          "photo": "https://robohash.org/architectoaccusamuseos.png?size=50x50&set=set1"
        }, {
          "superhero": "Hudsonian godwit",
          "publisher": "Kwilith",
          "realname": "Pris",
          "photo": "https://robohash.org/errorfugitmaiores.png?size=50x50&set=set1"
        }, {
          "superhero": "Oryx, fringe-eared",
          "publisher": "Divavu",
          "realname": "Tiebout",
          "photo": "https://robohash.org/doloresdoloremquequis.png?size=50x50&set=set1"
        }, {
          "superhero": "Worm snake (unidentified)",
          "publisher": "Devbug",
          "realname": "Fitzgerald",
          "photo": "https://robohash.org/eumuttotam.png?size=50x50&set=set1"
        }, {
          "superhero": "Turkey vulture",
          "publisher": "Yodoo",
          "realname": "Harp",
          "photo": "https://robohash.org/repellendustemporemaiores.png?size=50x50&set=set1"
        }, {
          "superhero": "Mule deer",
          "publisher": "Skalith",
          "realname": "Adelind",
          "photo": "https://robohash.org/voluptatemvitaenon.png?size=50x50&set=set1"
        }, {
          "superhero": "White-mantled colobus",
          "publisher": "Katz",
          "realname": "Annora",
          "photo": "https://robohash.org/dictaetoptio.png?size=50x50&set=set1"
        }, {
          "superhero": "Porcupine, crested",
          "publisher": "Youfeed",
          "realname": "Gracie",
          "photo": "https://robohash.org/perferendisullamtemporibus.png?size=50x50&set=set1"
        }, {
          "superhero": "Gerbil (unidentified)",
          "publisher": "Bluezoom",
          "realname": "Zoe",
          "photo": "https://robohash.org/architectoetdicta.png?size=50x50&set=set1"
        }, {
          "superhero": "Black spider monkey",
          "publisher": "Skilith",
          "realname": "Wynnie",
          "photo": "https://robohash.org/nisiquiexercitationem.png?size=50x50&set=set1"
        }, {
          "superhero": "Painted stork",
          "publisher": "Reallinks",
          "realname": "Danell",
          "photo": "https://robohash.org/culpamolestiaetemporibus.png?size=50x50&set=set1"
        }, {
          "superhero": "Lesser double-collared sunbird",
          "publisher": "Zooxo",
          "realname": "Trish",
          "photo": "https://robohash.org/accusantiumcommodiincidunt.png?size=50x50&set=set1"
        }, {
          "superhero": "Giant anteater",
          "publisher": "Thoughtblab",
          "realname": "Ellerey",
          "photo": "https://robohash.org/adquisquo.png?size=50x50&set=set1"
        }, {
          "superhero": "Penguin, little blue",
          "publisher": "Yoveo",
          "realname": "Eolande",
          "photo": "https://robohash.org/minimaasperiorestempore.png?size=50x50&set=set1"
        }, {
          "superhero": "Red kangaroo",
          "publisher": "Tekfly",
          "realname": "Mart",
          "photo": "https://robohash.org/laboreautemrem.png?size=50x50&set=set1"
        }, {
          "superhero": "Rhea, greater",
          "publisher": "Buzzshare",
          "realname": "Amalle",
          "photo": "https://robohash.org/dolorescumquequas.png?size=50x50&set=set1"
        }, {
          "superhero": "Devil, tasmanian",
          "publisher": "Jazzy",
          "realname": "Marcelo",
          "photo": "https://robohash.org/velquifuga.png?size=50x50&set=set1"
        }, {
          "superhero": "Yellow-brown sungazer",
          "publisher": "Tazz",
          "realname": "Gamaliel",
          "photo": "https://robohash.org/asperioresinventorenon.png?size=50x50&set=set1"
        }, {
          "superhero": "Phalarope, red-necked",
          "publisher": "Bubblemix",
          "realname": "Sky",
          "photo": "https://robohash.org/inciduntaccusamusofficiis.png?size=50x50&set=set1"
        }, {
          "superhero": "Cat, jungle",
          "publisher": "Yadel",
          "realname": "Con",
          "photo": "https://robohash.org/nonnobisat.png?size=50x50&set=set1"
        }, {
          "superhero": "Lilac-breasted roller",
          "publisher": "Tagpad",
          "realname": "Osborn",
          "photo": "https://robohash.org/corruptisedvoluptatum.png?size=50x50&set=set1"
        }, {
          "superhero": "Salmon, sockeye",
          "publisher": "Dabtype",
          "realname": "Boris",
          "photo": "https://robohash.org/corporisutdolores.png?size=50x50&set=set1"
        }, {
          "superhero": "Lizard, blue-tongued",
          "publisher": "Twitterbridge",
          "realname": "Cassondra",
          "photo": "https://robohash.org/eteligendiquo.png?size=50x50&set=set1"
        }, {
          "superhero": "Stork, black-necked",
          "publisher": "Skinix",
          "realname": "Homere",
          "photo": "https://robohash.org/dolorumasperioresquisquam.png?size=50x50&set=set1"
        }, {
          "superhero": "Insect, stick",
          "publisher": "Demivee",
          "realname": "Layne",
          "photo": "https://robohash.org/autemnamdoloribus.png?size=50x50&set=set1"
        }, {
          "superhero": "Red phalarope",
          "publisher": "Jetwire",
          "realname": "Antin",
          "photo": "https://robohash.org/estautest.png?size=50x50&set=set1"
        }, {
          "superhero": "American marten",
          "publisher": "Rooxo",
          "realname": "Melissa",
          "photo": "https://robohash.org/quisundequaerat.png?size=50x50&set=set1"
        }, {
          "superhero": "Beaver, european",
          "publisher": "Eazzy",
          "realname": "Terri-jo",
          "photo": "https://robohash.org/reprehenderitcumest.png?size=50x50&set=set1"
        }, {
          "superhero": "Cat, ringtail",
          "publisher": "Eire",
          "realname": "Hadrian",
          "photo": "https://robohash.org/earumenimdolores.png?size=50x50&set=set1"
        }, {
          "superhero": "Chital",
          "publisher": "Tambee",
          "realname": "Lazar",
          "photo": "https://robohash.org/eligendioditfacere.png?size=50x50&set=set1"
        }, {
          "superhero": "Iguana, marine",
          "publisher": "Jabbertype",
          "realname": "Goran",
          "photo": "https://robohash.org/similiquesapientedolore.png?size=50x50&set=set1"
        }, {
          "superhero": "Shrike, crimson-breasted",
          "publisher": "Flipstorm",
          "realname": "Korney",
          "photo": "https://robohash.org/impeditporroautem.png?size=50x50&set=set1"
        }, {
          "superhero": "Squirrel, red",
          "publisher": "Jaloo",
          "realname": "Dexter",
          "photo": "https://robohash.org/atestdeserunt.png?size=50x50&set=set1"
        }, {
          "superhero": "Black-fronted bulbul",
          "publisher": "Photolist",
          "realname": "Rosamund",
          "photo": "https://robohash.org/undeestaspernatur.png?size=50x50&set=set1"
        }, {
          "superhero": "Tortoise, radiated",
          "publisher": "Photobean",
          "realname": "Teddy",
          "photo": "https://robohash.org/voluptatemeaqueatque.png?size=50x50&set=set1"
        }, {
          "superhero": "American black bear",
          "publisher": "Kaymbo",
          "realname": "Sutton",
          "photo": "https://robohash.org/corporisutvoluptas.png?size=50x50&set=set1"
        }, {
          "superhero": "Chameleon (unidentified)",
          "publisher": "Skibox",
          "realname": "Lenora",
          "photo": "https://robohash.org/officiaoptiomaiores.png?size=50x50&set=set1"
        }, {
          "superhero": "Three-banded plover",
          "publisher": "Skipfire",
          "realname": "Bertha",
          "photo": "https://robohash.org/rerumassumendasapiente.png?size=50x50&set=set1"
        }, {
          "superhero": "Bear, grizzly",
          "publisher": "Fivechat",
          "realname": "Milli",
          "photo": "https://robohash.org/autemetnesciunt.png?size=50x50&set=set1"
        }, {
          "superhero": "Bird, pied butcher",
          "publisher": "Topiczoom",
          "realname": "Gussy",
          "photo": "https://robohash.org/etsintqui.png?size=50x50&set=set1"
        }, {
          "superhero": "White-browed sparrow weaver",
          "publisher": "Jabbersphere",
          "realname": "Misha",
          "photo": "https://robohash.org/inciduntinitaque.png?size=50x50&set=set1"
        }, {
          "superhero": "Badger, european",
          "publisher": "Vinte",
          "realname": "Issy",
          "photo": "https://robohash.org/praesentiumnequeillo.png?size=50x50&set=set1"
        }, {
          "superhero": "Brush-tailed bettong",
          "publisher": "Demizz",
          "realname": "Dena",
          "photo": "https://robohash.org/utmolestiaesoluta.png?size=50x50&set=set1"
        }, {
          "superhero": "Chestnut weaver",
          "publisher": "Jaxspan",
          "realname": "Donnamarie",
          "photo": "https://robohash.org/autnisiculpa.png?size=50x50&set=set1"
        }, {
          "superhero": "Kelp gull",
          "publisher": "Roomm",
          "realname": "Zea",
          "photo": "https://robohash.org/itaqueullamdignissimos.png?size=50x50&set=set1"
        }, {
          "superhero": "Spotted hyena",
          "publisher": "Flashspan",
          "realname": "Andonis",
          "photo": "https://robohash.org/voluptatibusametbeatae.png?size=50x50&set=set1"
        }, {
          "superhero": "Penguin, little blue",
          "publisher": "Oyoyo",
          "realname": "Calley",
          "photo": "https://robohash.org/quisquamoptioaut.png?size=50x50&set=set1"
        }, {
          "superhero": "Guerza",
          "publisher": "Devbug",
          "realname": "Jilly",
          "photo": "https://robohash.org/eumvoluptatibusenim.png?size=50x50&set=set1"
        }, {
          "superhero": "Snake, western patch-nosed",
          "publisher": "Vinder",
          "realname": "Rosalie",
          "photo": "https://robohash.org/recusandaeomnisea.png?size=50x50&set=set1"
        }, {
          "superhero": "Little brown dove",
          "publisher": "Photospace",
          "realname": "Danila",
          "photo": "https://robohash.org/quiaessevoluptas.png?size=50x50&set=set1"
        }, {
          "superhero": "Marten, american",
          "publisher": "Zoomlounge",
          "realname": "Gabe",
          "photo": "https://robohash.org/delenitiminusdoloribus.png?size=50x50&set=set1"
        }, {
          "superhero": "Jaguarundi",
          "publisher": "Gevee",
          "realname": "Lynelle",
          "photo": "https://robohash.org/animietconsequuntur.png?size=50x50&set=set1"
        }, {
          "superhero": "Snake, eastern indigo",
          "publisher": "Aivee",
          "realname": "Abagail",
          "photo": "https://robohash.org/repudiandaeetillum.png?size=50x50&set=set1"
        }, {
          "superhero": "Black-crowned night heron",
          "publisher": "Riffpedia",
          "realname": "Maryrose",
          "photo": "https://robohash.org/placeatessevoluptatibus.png?size=50x50&set=set1"
        }, {
          "superhero": "Vulture, turkey",
          "publisher": "Abata",
          "realname": "Omar",
          "photo": "https://robohash.org/quinostrumasperiores.png?size=50x50&set=set1"
        }, {
          "superhero": "Western patch-nosed snake",
          "publisher": "Meemm",
          "realname": "Ronica",
          "photo": "https://robohash.org/explicabofugitquia.png?size=50x50&set=set1"
        }, {
          "superhero": "California sea lion",
          "publisher": "Vinte",
          "realname": "Jade",
          "photo": "https://robohash.org/nihilquosnumquam.png?size=50x50&set=set1"
        }, {
          "superhero": "Cape cobra",
          "publisher": "Youbridge",
          "realname": "Aindrea",
          "photo": "https://robohash.org/eaquemollitiaaut.png?size=50x50&set=set1"
        }, {
          "superhero": "Bennett's wallaby",
          "publisher": "Dabjam",
          "realname": "Merilee",
          "photo": "https://robohash.org/eligendirerumrerum.png?size=50x50&set=set1"
        }, {
          "superhero": "Cape Barren goose",
          "publisher": "Feedmix",
          "realname": "Coral",
          "photo": "https://robohash.org/sequiipsumillo.png?size=50x50&set=set1"
        }, {
          "superhero": "Owl, australian masked",
          "publisher": "Miboo",
          "realname": "Farlay",
          "photo": "https://robohash.org/etofficiisest.png?size=50x50&set=set1"
        }, {
          "superhero": "Squirrel, african bush",
          "publisher": "Meemm",
          "realname": "Dodi",
          "photo": "https://robohash.org/mollitiaquaeratnon.png?size=50x50&set=set1"
        }, {
          "superhero": "Groundhog",
          "publisher": "Photobug",
          "realname": "Raoul",
          "photo": "https://robohash.org/dictadelectusblanditiis.png?size=50x50&set=set1"
        }, {
          "superhero": "Clark's nutcracker",
          "publisher": "Yambee",
          "realname": "Olly",
          "photo": "https://robohash.org/laudantiumlaboriosamnumquam.png?size=50x50&set=set1"
        }, {
          "superhero": "Barking gecko",
          "publisher": "Mynte",
          "realname": "Ursola",
          "photo": "https://robohash.org/illoexpeditaaut.png?size=50x50&set=set1"
        }, {
          "superhero": "Cape Barren goose",
          "publisher": "Meetz",
          "realname": "Valida",
          "photo": "https://robohash.org/illoquasiodio.png?size=50x50&set=set1"
        }, {
          "superhero": "Lion, asian",
          "publisher": "Jatri",
          "realname": "Sherwynd",
          "photo": "https://robohash.org/laborumaddoloribus.png?size=50x50&set=set1"
        }, {
          "superhero": "Common palm civet",
          "publisher": "Meembee",
          "realname": "Aura",
          "photo": "https://robohash.org/delectusquipariatur.png?size=50x50&set=set1"
        }, {
          "superhero": "Red meerkat",
          "publisher": "Rhynyx",
          "realname": "Benjamen",
          "photo": "https://robohash.org/ullamsitdicta.png?size=50x50&set=set1"
        }, {
          "superhero": "Duck, mountain",
          "publisher": "Omba",
          "realname": "Berky",
          "photo": "https://robohash.org/quodolorumminima.png?size=50x50&set=set1"
        }]
    """.trimIndent()

        private val gson = Gson()
        private val itemType = object:TypeToken<List<SuperHero>>() {}.type
        val superHeroList :List<SuperHero> = gson.fromJson(json,itemType)

    }

}

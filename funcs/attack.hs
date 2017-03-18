import System.IO.Unsafe
import System.Random

type HP = Int
type AP = Int
type Str = Int
type Guile = Int
type Anger = Int
type Item = (String, Dmg)
type XP = Int
type Dmg = Int
type Move = (Int, Int, Int)

type Guy = (HP, AP, Str, Guile, Anger, [Item], XP, String)

apMax = 15

hero :: Guy
hero = (100, 50, 3, 2, 0, [], 0, "Sue")

baddie :: Guy
baddie = (100, 50, 3, 2, 0, [], 0, "Bar Fly")

punch :: Move
punch = (1,3,5)

haymaker :: Move
haymaker = (2,8,10)

bottle :: Item
bottle = ("Bottle", -10)

cake :: Item
cake = ("Cake", 10)

hp :: Guy -> HP
hp (x,_,_,_,_,_,_,_) = x

ap :: Guy -> AP
ap (_,x,_,_,_,_,_,_) = x

str :: Guy -> Str
str (_,_,x,_,_,_,_,_) = x

guile :: Guy -> Guile
guile (_,_,_,x,_,_,_,_) = x

anger :: Guy -> Anger
anger (_,_,_,_,x,_,_,_) = x

items :: Guy -> [Item]
items (_,_,_,_,_,x,_,_) = x

xp :: Guy -> XP
xp (_,_,_,_,_,_,x,_) = x

name :: Guy -> String
name (_,_,_,_,_,_,_,x) = x

moveDmg :: Move -> Int
moveDmg (l,u,_) = rand l u

moveCost :: Move -> Int
moveCost (_,_,c) = c

rand :: Int -> Int -> Int
rand l u = unsafePerformIO (randomRIO (l,u))

d20 :: Int
-- d20 = rand 1 20
d20 = unsafePerformIO (randomRIO (1,20))

-- attack takes the Attacker Guy, the Defender Guy, the fight move performed
-- returns both guys minus AP and HP where appropriate + IO message to hit or miss

attack :: Guy -> Guy -> Move -> IO (Guy, Guy)
attack a d m | (rand 1 20) + guile a >= (rand 1 20) + guile d =
  do putStrLn "Hit"
     return guys
             | otherwise = do putStrLn "Miss"
                              return (att,d)
  where
    guys = (att, def)
    att = ( hp a,(ap a) - (moveCost m),str a, guile a, anger a, items a, xp a, name a)
    def = ( (hp d) - (rollDmg a d m),ap d,str d, guile d, anger d, items d, xp d, name d)

rollDmg :: Guy -> Guy -> Move -> Dmg
rollDmg a d m = ( (moveDmg m) * (str a) ) `div` (str d)

useItem :: Guy -> Item -> IO Guy
useItem g i | snd i < 0 = do putStr (fst i ++ " hits for " ++ show (snd i) ++ " damage!")
                             return g'
            | otherwise = do putStr (fst i ++ " heals " ++ show (snd i) ++ " damage!")
                             return g'
  where
    g' = ( (hp g) + (snd i),ap g,str g, guile g, anger g, items g, xp g, name g)

-- type Guy = (HP, AP, Str, Guile, Anger, [Item], XP, String)

skip :: Guy -> Guy
skip g = (hp g, apMax, str g, guile g, anger g, items g, xp g, name g )

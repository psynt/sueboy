import System.IO.Unsafe
import System.Random

data ItemType = Heal | Dmg | Pump

type HP = Int
type AP = Int
type Str = Int
type Guile = Int
type Anger = Int
type Item = (ItemType, Dmg)
type XP = Int
type Dmg = Int
type Move = (Int, Int)

type Guy = (HP, AP, Str, Guile, Anger, [Item], XP)

hero :: Guy
hero = (100, 50, 3, 2, 0, [], 0)

baddie :: Guy
baddie = (100, 50, 3, 2, 0, [], 0)

punch :: Move
punch = (1,3)

haymaker :: Move
haymaker = (2,8)

hp :: Guy -> HP
hp (x,_,_,_,_,_,_) = x

ap :: Guy -> AP
ap (_,x,_,_,_,_,_) = x

str :: Guy -> Str
str (_,_,x,_,_,_,_) = x

guile :: Guy -> Guile
guile (_,_,_,x,_,_,_) = x

anger :: Guy -> Anger
anger (_,_,_,_,x,_,_) = x

items :: Guy -> [Item]
items (_,_,_,_,_,x,_) = x

xp :: Guy -> XP
xp (_,_,_,_,_,_,x) = x

rand :: Int -> Int -> Int
rand l u = unsafePerformIO (randomRIO (l,u))

d20 :: Int
-- d20 = rand 1 20
d20 = unsafePerformIO (randomRIO (1,20))

-- attack takes the Attacker, the Defender, the fight move performed
-- returns the Dmg to substract from Defender + IO message to hit or miss
attack :: Guy -> Guy -> Move -> IO Dmg
attack a d m | (rand 1 20) + guile a >= (rand 1 20) + guile d = do putStrLn "Hit"
                                                                   return (rollDmg a d m)
             | otherwise = do putStrLn "Miss"
                              return 0

rollDmg :: Guy -> Guy -> Move -> Dmg
rollDmg a d m = (mDmg * (str a)) `div` (str d)
  where
    mDmg = rand (fst m) (snd m)

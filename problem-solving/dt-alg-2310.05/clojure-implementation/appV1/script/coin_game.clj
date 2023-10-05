(defn coin-game [coins]
  (let [n (count coins)]
    (if (= n 0)
      0
      (let [first-coin (first coins)
            last-coin (last coins)
            rest-coins (rest coins)
            without-first-coin-value (coin-game rest-coins)
            without-last-coin-value (coin-game (reverse rest-coins))]
        (max first-coin (+ without-first-coin-value last-coin)
              last-coin (+ without-last-coin-value first-coin))))))

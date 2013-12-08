(ns tricky_card_game)

(defn solve [trump]
  (let [winner (fn [cards]
                 (let [cards-trump (if (nil? trump) ((first cards) :suit) trump)]
                   (->> (filter #(= cards-trump (% :suit)) cards)
                        (reduce #(if (> (%1 :rank) (%2 :rank)) %1 %2))
                   )
                 )
               )]
    winner
  )
)
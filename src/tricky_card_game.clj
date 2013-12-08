(ns tricky_card_game)

(defn solve [trump]
  (let [winner (fn [cards]
                 (if (nil? trump) (->> (filter #(= ((first cards) :suit) (% :suit)) cards)
                                       (reduce #(if (> (%1 :rank) (%2 :rank)) %1 %2))
                                  )
                                  (->> (filter #(= trump (% :suit)) cards)
                                       (reduce #(if (> (%1 :rank) (%2 :rank)) %1 %2))
                                  )
                 )
               )]
    winner
  )
)
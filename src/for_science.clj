(ns for_science)

(use 'clojure.set)

(defn can-reach-cheese
  ([maze]
    (let [height (count maze)
          width (count (maze 0))
          pos-y (->> (map vector (range height) maze)
                     (filter #(.contains (% 1) "M"))
                     (map #(% 0))
                     (first))
          pos-x (->> (map vector (range width) (maze pos-y))
                     (filter #(= (% 1) \M))
                     (map #(% 0))
                     (first))]
      (can-reach-cheese maze height width pos-x pos-y #{[pos-x pos-y]})
    )
  )
  ([maze height width pos-x pos-y cache]
    (let [delta [[0 -1] [1 0] [0 1] [-1 0]]
          found (= (get (maze pos-y) pos-x) \C)
          next-positions (->> (map #(vector (+ pos-x (% 0)) (+ pos-y (% 1))) delta)
                              (filter #(and (>= (% 0) 0) (< (% 0) width) (>= (% 1) 0) (< (% 1) height)))
                              (filter #(not= (get (maze (% 1)) (% 0)) \#))
                              (filter #(not (contains? cache %))))
          next-cache (clojure.set/union cache (into #{} next-positions))]
      (if found true
                (true? (some true? (map #(can-reach-cheese maze height width (% 0) (% 1) next-cache) next-positions))))
    )
  )
)

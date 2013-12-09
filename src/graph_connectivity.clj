(ns graph_connectivity)

(defn connected [edges]
  (let [vertices (set (apply concat edges))
        connected-vertices (fn connected-vertices
                             ([vertex] (connected-vertices vertex #{}))
                             ([vertex cache]
                               (let [adjacent-vertices (->> (apply concat (filter #(contains? (set %) vertex) edges))
                                                            (filter #(not (contains? cache %)))
                                                       )]
                                 (if (empty? adjacent-vertices)
                                   cache
                                   (set (mapcat #(connected-vertices % (set (conj cache %))) adjacent-vertices))
                                 )
                               )
                             )
                           )
       ]
    (every? #(= vertices (connected-vertices %)) vertices)
  )
)
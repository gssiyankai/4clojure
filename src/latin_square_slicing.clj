(ns latin_square_slicing)

(defn latin-square? [square]
  (let [rows (identity square)
        columns (reduce #(map flatten (map vector %1 %2)) rows)
        distinct-elements (map #(distinct %) (concat rows columns))
        distinct-square-elements (reduce #(apply conj %1 %2) #{} distinct-elements)]
    (and
      (apply = (conj (map #(count %) distinct-elements)
                     (count square)
                     (count (first square))
                     (count distinct-square-elements)))
      (not (contains? distinct-square-elements '*)))
  )
)

(defn pad [v order]
  (let [n (- order (count v))]
    (for [i (range 0 (inc n))
          :let [j (- n i)]]
      (concat (repeat i '*) v (repeat j '*))
    )
  )
)

(defn cartesian-product
  ;; Patched version of clojure.contrib.combinatorics/cartesian-product
  [seqs]
  (let [v-original-seqs (vec seqs)
        step
        (fn step [v-seqs]
          (let [increment
                (fn [v-seqs]
                  (loop [i (dec (count v-seqs)), v-seqs v-seqs]
                    (when (> i -1)
                      (if-let [rst (next (v-seqs i))]
                        (assoc v-seqs i rst)
                        (recur (dec i) (assoc v-seqs i (v-original-seqs i)))))))]
            (when v-seqs
              (cons (map first v-seqs)
                (lazy-seq (step (increment v-seqs)))))))]
  (step v-original-seqs)))

(defn alignments [vectors order]
  (let [pads (reduce #(concat %1 (vector (pad %2 order))) [] vectors)]
    (cartesian-product pads)
  )
)

(defn process [vectors]
  (let [y-order (count vectors)
        x-order (reduce #(max %1 (count %2)) 0 vectors)
        rows (identity vectors)
        columns (reduce #(map flatten (map vector %1 %2)) rows)]
    (->> (for [o (range 2 (inc (max x-order y-order)))
               x1 (range x-order)
               y1 (range y-order)
               alignment (alignments vectors x-order)
               :let [x2 (+ x1 o)
                     y2 (+ y1 o)]
               :when (and (< x2 (inc x-order))
                          (< y2 (inc y-order)))]
           (let [sub-rows (subvec (vec alignment) y1 y2)
                 square (map (fn [i] (subvec (vec i) x1 x2)) sub-rows)]
             (when (latin-square? square) square)
           ))
         (filter #(not (nil? %)))
         (distinct)
         (group-by #(count %))
         (map #(vector (key %) (count (val %))))
         (into {})
    )
  )
)

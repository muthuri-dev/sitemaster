/*
  Warnings:

  - You are about to drop the `_ProjectToWorker` table. If the table is not empty, all the data it contains will be lost.
  - Added the required column `projectId` to the `workers` table without a default value. This is not possible if the table is not empty.

*/
-- DropForeignKey
ALTER TABLE "_ProjectToWorker" DROP CONSTRAINT "_ProjectToWorker_A_fkey";

-- DropForeignKey
ALTER TABLE "_ProjectToWorker" DROP CONSTRAINT "_ProjectToWorker_B_fkey";

-- AlterTable
ALTER TABLE "workers" ADD COLUMN     "projectId" TEXT NOT NULL;

-- DropTable
DROP TABLE "_ProjectToWorker";

-- CreateIndex
CREATE INDEX "workers_projectId_idx" ON "workers"("projectId");

-- AddForeignKey
ALTER TABLE "workers" ADD CONSTRAINT "workers_projectId_fkey" FOREIGN KEY ("projectId") REFERENCES "projects"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
